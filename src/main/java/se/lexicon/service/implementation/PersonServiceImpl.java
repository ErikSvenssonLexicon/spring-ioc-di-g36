package se.lexicon.service.implementation;

import se.lexicon.dao.interfaces.PersonDAO;
import se.lexicon.dao.interfaces.PersonIdSequencer;
import se.lexicon.model.dto.PersonDTO;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.Person;
import se.lexicon.model.entity.UserCredentials;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.interfaces.PersonService;
import se.lexicon.service.interfaces.UserCredentialsService;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

    private final PersonDAO dao;
    private final PersonIdSequencer sequencer;
    private final PersonFactoryService factoryService;
    private final UserCredentialsService userCredentialsService;

    public PersonServiceImpl(
            PersonDAO dao,
            PersonIdSequencer sequencer,
            PersonFactoryService factoryService,
            UserCredentialsService userCredentialsService) {
        this.dao = dao;
        this.sequencer = sequencer;
        this.factoryService = factoryService;
        this.userCredentialsService = userCredentialsService;
    }

    @Override
    public Person create(String username, String password, ApplicationRole role, String firstName, String lastName, String email){
        if(username == null || password == null || role == null || firstName == null || lastName == null || email == null){
            throw new IllegalArgumentException("At least one parameter was null");
        }
        if(dao.findByEmail(email).isPresent()){
            throw new RuntimeException("Email " + email + " is already taken");
        }

        UserCredentials userCredentials = userCredentialsService.create(username, password, role);
        Person person = new Person(sequencer.nextId(), firstName, lastName, email, userCredentials);
        return dao.persist(person);
    }

    @Override
    public PersonDTO findById(int id){
        return dao.findById(id)
                .map(factoryService::convertToDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public PersonDTO findByEmail(String email){
        return dao.findByEmail(email)
                .map(factoryService::convertToDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Collection<PersonDTOBasic> findAll(){
        return dao.findAll().stream()
                .map(factoryService::convertToBasicDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Person update(int id, PersonDTOBasic personDTO){
        Person toUpdate = dao.findById(id).orElseThrow(RuntimeException::new);
        Optional<Person> personOptional = dao.findByEmail(personDTO.getEmail());
        if(personOptional.isPresent()){
            if(personOptional.get().getId() != id){
                throw new IllegalArgumentException("Email " + personDTO.getEmail() + " is already taken");
            }
        }
        toUpdate.setEmail(personDTO.getEmail());
        toUpdate.setFirstName(personDTO.getFirstName());
        toUpdate.setLastName(personDTO.getLastName());
        return toUpdate;
    }

    @Override
    public void remove(int id){
        dao.findById(id).ifPresent(dao::remove);
    }


}
