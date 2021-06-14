package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.PersonDAOCollectionImpl;
import se.lexicon.dao.TodoItemDAOCollectionImpl;
import se.lexicon.dao.UserCredentialsDAOCollectionImpl;
import se.lexicon.dao.sequencers.PersonIdSequencerImpl;
import se.lexicon.dao.sequencers.TodoItemIdSequencerImpl;
import se.lexicon.dao.sequencers.UserCredentialsIdSequencerImpl;

@Configuration
public class ApplicationConfig {


    @Bean
    PersonIdSequencerImpl personIdSequencerImpl(){
        return new PersonIdSequencerImpl();
    }

    @Bean
    TodoItemIdSequencerImpl todoItemIdSequencerImpl(){
        return new TodoItemIdSequencerImpl();
    }

    @Bean
    UserCredentialsIdSequencerImpl userCredentialsIdSequencerImpl(){
        return new UserCredentialsIdSequencerImpl();
    }

    @Bean
    PersonDAOCollectionImpl personDAOCollectionImpl(){
        return new PersonDAOCollectionImpl();
    }

    @Bean
    TodoItemDAOCollectionImpl todoItemDAOCollectionImpl(){
        return new TodoItemDAOCollectionImpl();
    }

    @Bean
    UserCredentialsDAOCollectionImpl userCredentialsDAOCollectionImpl(){
        return new UserCredentialsDAOCollectionImpl();
    }


}
