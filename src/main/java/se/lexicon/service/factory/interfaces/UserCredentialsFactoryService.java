package se.lexicon.service.factory.interfaces;

import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.UserCredentials;

public interface UserCredentialsFactoryService {
    UserCredentialsDTO convertToDTO(UserCredentials person);
}
