package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.service.factory.PersonFactoryServiceImpl;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

@Configuration
public class PersonFactoryServiceConfig {

    private UserCredentialsFactoryService userCredentialsFactoryService;

    @Autowired
    public void setUserCredentialsFactoryService(UserCredentialsFactoryService userCredentialsFactoryService) {
        this.userCredentialsFactoryService = userCredentialsFactoryService;
    }

    @Bean
    public PersonFactoryServiceImpl personFactoryServiceImpl(){
        PersonFactoryServiceImpl personFactoryService = new PersonFactoryServiceImpl();
        personFactoryService.setUserCredentialsFactoryService(userCredentialsFactoryService);
        return personFactoryService;
    }

}
