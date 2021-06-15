package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.service.factory.TodoItemFactoryServiceImpl;
import se.lexicon.service.factory.interfaces.PersonFactoryService;

@Configuration
public class TodoItemFactoryServiceConfig {

    private PersonFactoryService personFactoryService;

    @Autowired
    public void setPersonFactoryService(PersonFactoryService personFactoryService) {
        this.personFactoryService = personFactoryService;
    }

    @Bean
    public TodoItemFactoryServiceImpl todoItemFactoryServiceImpl(){
        TodoItemFactoryServiceImpl todoItemFactoryService = new TodoItemFactoryServiceImpl();
        todoItemFactoryService.setPersonFactoryService(personFactoryService);
        return todoItemFactoryService;
    }

}
