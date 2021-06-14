package se.lexicon.service.interfaces;

import se.lexicon.model.dto.PersonDTO;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.Person;

import java.util.Collection;

public interface PersonService {
    Person create(String username, String password, ApplicationRole role, String firstName, String lastName, String email);

    PersonDTO findById(int id);

    PersonDTO findByEmail(String email);

    Collection<PersonDTOBasic> findAll();

    Person update(int id, PersonDTOBasic personDTO);

    void remove(int id);
}
