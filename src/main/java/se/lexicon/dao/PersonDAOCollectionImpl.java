package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.model.entity.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class PersonDAOCollectionImpl implements PersonDAO {

    private final Set<Person> storage;


    public PersonDAOCollectionImpl() {
        this.storage = new HashSet<>();
    }

    @Override
    public Person persist(Person entity) {
        if(entity == null){
            throw new IllegalArgumentException("Persist aborted entity was null");
        }
        storage.add(entity);
        return entity;
    }

    @Override
    public Optional<Person> findById(Integer integer) {
        return storage.stream()
            .filter(person -> person.getId() == integer)
            .findFirst();
    }

    @Override
    public Collection<Person> findAll() {
        return new HashSet<>(storage);
    }


    @Override
    public void remove(Person entity) {
        storage.remove(entity);
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return storage.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst();
    }
}
