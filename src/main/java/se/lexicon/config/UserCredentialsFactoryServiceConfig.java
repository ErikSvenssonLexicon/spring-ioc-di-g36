package se.lexicon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.service.factory.UserDetailsFactoryServiceImpl;
import se.lexicon.service.factory.interfaces.PersonFactoryService;

@Configuration
public class UserCredentialsFactoryServiceConfig {

    private PersonFactoryService personFactoryService;

    @Autowired
    public void setPersonFactoryService(PersonFactoryService personFactoryService) {
        this.personFactoryService = personFactoryService;
    }

    @Bean
    public UserDetailsFactoryServiceImpl userDetailsFactoryServiceImpl(){
        UserDetailsFactoryServiceImpl userDetailsFactoryService = new UserDetailsFactoryServiceImpl();
        userDetailsFactoryService.setPersonFactoryService(personFactoryService);
        return userDetailsFactoryService;
    }

}
