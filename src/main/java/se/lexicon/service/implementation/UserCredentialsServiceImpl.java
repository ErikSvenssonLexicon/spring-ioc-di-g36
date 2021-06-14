package se.lexicon.service.implementation;

import se.lexicon.dao.interfaces.UserCredentialsDAO;
import se.lexicon.dao.interfaces.UserCredentialsIdSequencer;
import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.ApplicationRole;
import se.lexicon.model.entity.UserCredentials;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;
import se.lexicon.service.interfaces.UserCredentialsService;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsDAO dao;
    private final UserCredentialsIdSequencer sequencer;
    private final UserCredentialsFactoryService factoryService;

    public UserCredentialsServiceImpl(UserCredentialsDAO dao, UserCredentialsIdSequencer sequencer, UserCredentialsFactoryService factoryService) {
        this.dao = dao;
        this.sequencer = sequencer;
        this.factoryService = factoryService;
    }

    @Override
    public UserCredentials create(String username, String password, ApplicationRole role) {
        UserCredentials userCredentials = new UserCredentials(username.trim(), password.trim(), role);
        if(dao.findByUsername(username).isPresent()){
            throw new RuntimeException("Username " + username + " is already taken");
        }
        userCredentials.setId(sequencer.nextId());
        return dao.persist(userCredentials);
    }

    @Override
    public UserCredentialsDTO findById(int id) {
        return dao.findById(id)
                .map(factoryService::convertToDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserCredentialsDTO findByUsername(String username) {
        return dao.findByUsername(username)
                .map(factoryService::convertToDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Collection<UserCredentialsDTO> findAll() {
        return dao.findAll().stream()
                .map(factoryService::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserCredentials update(int id, UserCredentialsDTO userCredentialsDTO) {
        if(userCredentialsDTO == null) throw new RuntimeException();
        UserCredentials toUpdate = dao.findById(id).orElseThrow(RuntimeException::new);

        toUpdate.setUsername(userCredentialsDTO.getUsername());
        toUpdate.setRole(ApplicationRole.valueOf(userCredentialsDTO.getRole()));
        return toUpdate;
    }

    @Override
    public void remove(int id) {
        UserCredentials userCredentials =  dao.findById(id).orElseThrow(RuntimeException::new);
        dao.remove(userCredentials);
    }
}
