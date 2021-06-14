package se.lexicon.service.interfaces;

import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.UserCredentials;

import java.util.Collection;

public interface UserCredentialsService {

    UserCredentials create(String username, String password, ApplicationRole role);
    UserCredentialsDTO findById(int id);
    UserCredentialsDTO findByUsername(String username);
    Collection<UserCredentialsDTO> findAll();
    UserCredentials update(int id, UserCredentialsDTO userCredentialsDTO);
    void remove(int id);


}
