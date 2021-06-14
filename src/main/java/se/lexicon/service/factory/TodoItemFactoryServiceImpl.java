package se.lexicon.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.dto.TodoItemDTO;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.Person;
import se.lexicon.model.entity.TodoItem;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoItemFactoryServiceImpl implements TodoItemFactoryService {

    private PersonFactoryService personFactoryService;


    @Autowired
    public void setPersonFactoryService(PersonFactoryService personFactoryService) {
        this.personFactoryService = personFactoryService;
    }

    @Override
    public TodoItemDTO convertToDTO(TodoItem todoItem) {
        TodoItemDTO todoItemDTO = null;
        if(todoItem != null){
            todoItemDTO = new TodoItemDTO();
            todoItemDTO.setId(todoItem.getId());
            todoItemDTO.setTopic(todoItem.getTopic());
            todoItemDTO.setDescription(todoItem.getDescription());
            todoItemDTO.setDone(todoItemDTO.isDone());
            todoItemDTO.setPayment(todoItem.getPayment());

            List<PersonDTOBasic> personDTOBasicList = new ArrayList<>();
            for(Person person : todoItem.getAssignees()){
                personDTOBasicList.add(personFactoryService.convertToBasicDTO(person));
            }

            todoItemDTO.setAssignees(personDTOBasicList);
            todoItemDTO.setOwner(personFactoryService.convertToBasicDTO(todoItem.getOwner()));
        }
        return todoItemDTO;
    }

    @Override
    public TodoItemDTOBasic convertToBasicDTO(TodoItem todoItem) {
        TodoItemDTOBasic todoItemDTOBasic = null;
        if(todoItem != null){
            todoItemDTOBasic = new TodoItemDTOBasic();
            todoItemDTOBasic.setId(todoItem.getId());
            todoItemDTOBasic.setTopic(todoItem.getTopic());
            todoItemDTOBasic.setDescription(todoItem.getDescription());
            todoItemDTOBasic.setPayment(todoItem.getPayment());
            todoItemDTOBasic.setDone(todoItem.isDone());
            todoItemDTOBasic.setOwner(personFactoryService.convertToBasicDTO(todoItem.getOwner()));
        }
        return todoItemDTOBasic;
    }
}
