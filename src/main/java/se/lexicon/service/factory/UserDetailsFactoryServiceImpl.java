package se.lexicon.service.factory;

import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.UserCredentials;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

public class UserDetailsFactoryServiceImpl implements UserCredentialsFactoryService {

    private PersonFactoryService personFactoryService;

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
