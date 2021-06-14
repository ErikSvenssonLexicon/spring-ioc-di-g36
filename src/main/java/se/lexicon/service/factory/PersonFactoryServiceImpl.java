package se.lexicon.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.model.dto.PersonDTO;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.Person;
import se.lexicon.model.entity.TodoItem;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonFactoryServiceImpl implements PersonFactoryService {

    private UserCredentialsFactoryService userCredentialsFactoryService;
    private TodoItemFactoryService todoItemFactoryService;

    @Autowired
    public void setUserCredentialsFactoryService(UserCredentialsFactoryService userCredentialsFactoryService) {
        this.userCredentialsFactoryService = userCredentialsFactoryService;
    }

    @Autowired
    public void setTodoItemFactoryService(TodoItemFactoryService todoItemFactoryService) {
        this.todoItemFactoryService = todoItemFactoryService;
    }

    @Override
    public PersonDTO convertToDTO(Person person) {
        PersonDTO personDTO = null;
        if(person != null){
            personDTO = new PersonDTO();
            personDTO.setId(person.getId());
            personDTO.setEmail(person.getEmail());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personDTO.setUserCredentials(userCredentialsFactoryService.convertToDTO(person.getUserCredentials()));
            List<TodoItemDTOBasic> dtoBasicList = new ArrayList<>();
            for(TodoItem todoItem : person.getTodoItems()){
                dtoBasicList.add(todoItemFactoryService.convertToBasicDTO(todoItem));
            }
            personDTO.setTodoItems(dtoBasicList);
        }
        return personDTO;
    }

    @Override
    public PersonDTOBasic convertToBasicDTO(Person person) {
        PersonDTOBasic personDTO = new PersonDTOBasic();
        if(person != null){
            personDTO.setId(person.getId());
            personDTO.setEmail(person.getEmail());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
        }
        return personDTO;
    }
}
