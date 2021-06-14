package se.lexicon.service.factory.interfaces;

import se.lexicon.model.dto.PersonDTO;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.entity.Person;

public interface PersonFactoryService {
    PersonDTO convertToDTO(Person person);
    PersonDTOBasic convertToBasicDTO(Person person);
}
