package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.dao.interfaces.TodoItemDAO;
import se.lexicon.dao.interfaces.TodoItemIdSequencer;
import se.lexicon.dao.interfaces.UserCredentialsDAO;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;
import se.lexicon.service.implementation.TodoItemServiceImpl;
import se.lexicon.service.interfaces.TodoItemService;

@Configuration
public class TodoItemServiceConfig {
    private UserCredentialsDAO userCredentialsDAO;
    private PersonDAO personDAO;
    private TodoItemDAO todoItemDAO;
    private TodoItemFactoryService todoItemFactoryService;
    private TodoItemIdSequencer sequencer;

    @Autowired
    public void setUserCredentialsDAO(UserCredentialsDAO userCredentialsDAO) {
        this.userCredentialsDAO = userCredentialsDAO;
    }

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Autowired
    public void setTodoItemDAO(TodoItemDAO todoItemDAO) {
        this.todoItemDAO = todoItemDAO;
    }

    @Autowired
    public void setTodoItemFactoryService(TodoItemFactoryService todoItemFactoryService) {
        this.todoItemFactoryService = todoItemFactoryService;
    }

    @Autowired
    public void setSequencer(TodoItemIdSequencer sequencer) {
        this.sequencer = sequencer;
    }

    @Bean
    public TodoItemService todoItemFactoryService(){
        return new TodoItemServiceImpl(
                userCredentialsDAO,personDAO,todoItemDAO,todoItemFactoryService,sequencer
        );
    }
}
