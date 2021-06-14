package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.interfaces.UserCredentialsDAO;
import se.lexicon.model.entity.UserCredentials;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class UserCredentialsDAOCollectionImpl implements UserCredentialsDAO {

    private final Set<UserCredentials> storage;

    public UserCredentialsDAOCollectionImpl() {
        storage = new HashSet<>();
    }

    @Override
    public UserCredentials persist(UserCredentials entity) {
        if(entity == null) throw new IllegalArgumentException("UserCredentials entity was null");
        storage.add(entity);
        return entity;
    }

    @Override
    public Optional<UserCredentials> findById(Integer integer) {
        return storage.stream()
                .filter(userCredentials -> userCredentials.getId() == integer)
                .findFirst();
    }

    @Override
    public Collection<UserCredentials> findAll() {
        return new HashSet<>(storage);
    }

    @Override
    public void remove(UserCredentials entity) {
        storage.remove(entity);
    }

    @Override
    public Optional<UserCredentials> findByUsername(String username) {
        return storage.stream()
                .filter(userCredentials -> userCredentials.getUsername().equals(username))
                .findFirst();
    }
}
