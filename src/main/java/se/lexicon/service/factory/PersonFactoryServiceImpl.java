package se.lexicon.service.factory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.model.dto.PersonDTO;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.Person;
import se.lexicon.model.entity.TodoItem;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonFactoryServiceImpl implements PersonFactoryService {

    private final ModelMapper modelMapper;

    @Autowired
    public PersonFactoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDTO convertToDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonDTOBasic convertToBasicDTO(Person person) {
        return modelMapper.map(person, PersonDTOBasic.class);
    }
}
