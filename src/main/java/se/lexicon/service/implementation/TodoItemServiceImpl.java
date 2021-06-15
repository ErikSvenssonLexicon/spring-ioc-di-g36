package se.lexicon.service.implementation;

import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.dao.interfaces.TodoItemDAO;
import se.lexicon.dao.interfaces.TodoItemIdSequencer;
import se.lexicon.dao.interfaces.UserCredentialsDAO;
import se.lexicon.model.dto.TodoItemDTO;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.Person;
import se.lexicon.model.entity.TodoItem;
import se.lexicon.model.entity.UserCredentials;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;
import se.lexicon.service.interfaces.TodoItemService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemServiceImpl implements TodoItemService {

    private final UserCredentialsDAO userCredentialsDAO;
    private final PersonDAO personDAO;
    private final TodoItemDAO todoItemDAO;
    private final TodoItemFactoryService todoItemFactoryService;
    private final TodoItemIdSequencer sequencer;

    public TodoItemServiceImpl(
            UserCredentialsDAO userCredentialsDAO,
            PersonDAO personDAO,
            TodoItemDAO todoItemDAO,
            TodoItemFactoryService todoItemFactoryService,
            TodoItemIdSequencer sequencer) {
        this.userCredentialsDAO = userCredentialsDAO;
        this.personDAO = personDAO;
        this.todoItemDAO = todoItemDAO;
        this.todoItemFactoryService = todoItemFactoryService;
        this.sequencer = sequencer;
    }

    @Override
    public TodoItem create(String topic, String description, BigDecimal payment, String ownerUsername) {
        if(topic == null || description == null || payment == null || ownerUsername == null){
            throw new IllegalArgumentException("Create aborted at null on one argument was found");
        }

        if(payment.doubleValue() <= 0){
            throw new IllegalArgumentException("Payment had a negative value");
        }

        UserCredentials owner = userCredentialsDAO.findByUsername(ownerUsername)
                .orElseThrow(() -> new IllegalArgumentException("Create aborted to user with username " + ownerUsername + " was found"));

        TodoItem todoItem = new TodoItem(sequencer.nextId(), topic, description, payment, false, owner.getPersonData());

        return todoItemDAO.persist(todoItem);
    }

    @Override
    public TodoItemDTO findById(int id) {
        return todoItemDAO.findById(id)
                .map(todoItemFactoryService::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Could not find todoitem with id" + id));
    }

    @Override
    public List<TodoItemDTOBasic> findAll() {
        return todoItemDAO.findAll()
                .stream()
                .map(todoItemFactoryService::convertToBasicDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TodoItem update(int id, TodoItemDTO todoItemDTO) {
        TodoItem todoItem = todoItemDAO.findById(id).orElseThrow(RuntimeException::new);
        if(todoItemDTO == null) throw new IllegalArgumentException("dto was null");

        todoItem.setDescription(todoItemDTO.getDescription());
        todoItem.setDone(todoItemDTO.isDone());
        todoItem.setTopic(todoItemDTO.getTopic());
        todoItem.setPayment(todoItemDTO.getPayment());

        return todoItem;
    }

    @Override
    public TodoItemDTO addAssignee(int personId, int todoId) {
        Person person = personDAO.findById(personId).orElseThrow(RuntimeException::new);
        TodoItem todoItem = todoItemDAO.findById(todoId).orElseThrow(RuntimeException::new);
        todoItem.addAssignee(person);
        return todoItemFactoryService.convertToDTO(todoItem);
    }

    @Override
    public TodoItemDTO removeAssignee(int personId, int todoId) {
        Person person = personDAO.findById(personId).orElseThrow(RuntimeException::new);
        TodoItem todoItem = todoItemDAO.findById(todoId).orElseThrow(RuntimeException::new);
        todoItem.removeAssignee(person);
        return todoItemFactoryService.convertToDTO(todoItem);
    }

    @Override
    public void remove(int id) {
        todoItemDAO.findById(id).ifPresent(todoItemDAO::remove);
    }
}
