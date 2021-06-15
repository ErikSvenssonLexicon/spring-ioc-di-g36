package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.PersonDAOCollectionImpl;
import se.lexicon.dao.TodoItemDAOCollectionImpl;
import se.lexicon.dao.UserCredentialsDAOCollectionImpl;
import se.lexicon.dao.sequencers.PersonIdSequencerImpl;
import se.lexicon.dao.sequencers.TodoItemIdSequencerImpl;
import se.lexicon.dao.sequencers.UserCredentialsIdSequencerImpl;
import se.lexicon.service.factory.PersonFactoryServiceImpl;
import se.lexicon.service.factory.TodoItemFactoryServiceImpl;
import se.lexicon.service.factory.UserDetailsFactoryServiceImpl;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

@Configuration
public class ApplicationConfig {

    @Bean
    public PersonIdSequencerImpl personIdSequencerImpl(){
        return new PersonIdSequencerImpl();
    }

    @Bean
    public TodoItemIdSequencerImpl todoItemIdSequencerImpl(){
        return new TodoItemIdSequencerImpl();
    }

    @Bean
    public UserCredentialsIdSequencerImpl userCredentialsIdSequencerImpl(){
        return new UserCredentialsIdSequencerImpl();
    }

    @Bean
    public PersonDAOCollectionImpl personDAOCollectionImpl(){
        return new PersonDAOCollectionImpl();
    }

    @Bean
    public TodoItemDAOCollectionImpl todoItemDAOCollectionImpl(){
        return new TodoItemDAOCollectionImpl();
    }

    @Bean
    public UserCredentialsDAOCollectionImpl userCredentialsDAOCollectionImpl(){
        return new UserCredentialsDAOCollectionImpl();
    }













}
