package se.lexicon.dao.interfaces;

import se.lexicon.model.entity.Person;

import java.util.Optional;

public interface PersonDAO extends GenericCRUD<Person, Integer>{
    Optional<Person> findByEmail(String email);
}
