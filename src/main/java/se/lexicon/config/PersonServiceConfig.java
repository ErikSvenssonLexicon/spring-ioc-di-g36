package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.dao.interfaces.PersonIdSequencer;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.implementation.PersonServiceImpl;
import se.lexicon.service.interfaces.UserCredentialsService;

@Configuration
public class PersonServiceConfig {

    private PersonDAO dao;
    private PersonIdSequencer sequencer;
    private PersonFactoryService factoryService;
    private UserCredentialsService userCredentialsService;

    @Autowired
    public void setDao(PersonDAO dao) {
        this.dao = dao;
    }
    @Autowired
    public void setSequencer(PersonIdSequencer sequencer) {
        this.sequencer = sequencer;
    }
    @Autowired
    public void setFactoryService(PersonFactoryService factoryService) {
        this.factoryService = factoryService;
    }
    @Autowired
    public void setUserCredentialsService(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @Bean
    public PersonServiceImpl personService(){
        return new PersonServiceImpl(
                dao,sequencer,factoryService,userCredentialsService
        );
    }
}
