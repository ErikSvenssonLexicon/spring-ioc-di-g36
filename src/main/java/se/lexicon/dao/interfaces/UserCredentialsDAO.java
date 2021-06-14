package se.lexicon.dao.interfaces;

import se.lexicon.model.entity.UserCredentials;

import java.util.Optional;

public interface UserCredentialsDAO extends GenericCRUD<UserCredentials, Integer>{
    Optional<UserCredentials> findByUsername(String username);
}
