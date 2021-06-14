package se.lexicon.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.UserCredentials;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

@Component
public class UserDetailsFactoryServiceImpl implements UserCredentialsFactoryService {

    private PersonFactoryService personFactoryService;

    @Autowired
    public void setPersonFactoryService(PersonFactoryService personFactoryService) {
        this.personFactoryService = personFactoryService;
    }

    @Override
    public UserCredentialsDTO convertToDTO(UserCredentials userCredentials) {
        UserCredentialsDTO userCredentialsDTO = null;
        if(userCredentials != null){
            userCredentialsDTO = new UserCredentialsDTO();
            userCredentialsDTO.setId(userCredentials.getId());
            userCredentialsDTO.setUsername(userCredentials.getUsername());
            userCredentialsDTO.setRole(userCredentials.getRole().getRole());
            userCredentialsDTO.setPersonData(personFactoryService.convertToBasicDTO(userCredentials.getPersonData()));
        }
        return userCredentialsDTO;
    }
}
