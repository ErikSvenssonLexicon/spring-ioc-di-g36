package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.interfaces.UserCredentialsDAO;
import se.lexicon.dao.interfaces.UserCredentialsIdSequencer;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;
import se.lexicon.service.implementation.UserCredentialsServiceImpl;
import se.lexicon.service.interfaces.UserCredentialsService;

@Configuration
public class UserCredentialsServiceConfig {
    private UserCredentialsDAO dao;
    private UserCredentialsIdSequencer sequencer;
    private UserCredentialsFactoryService factoryService;

    @Autowired
    public void setDao(UserCredentialsDAO dao) {
        this.dao = dao;
    }

    @Autowired
    public void setSequencer(UserCredentialsIdSequencer sequencer) {
        this.sequencer = sequencer;
    }

    @Autowired
    public void setFactoryService(UserCredentialsFactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Bean
    public UserCredentialsService userCredentialsService(){
        return new UserCredentialsServiceImpl(
                dao, sequencer, factoryService
        );
    }
}
