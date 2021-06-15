package se.lexicon.service.factory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import se.lexicon.model.dto.UserCredentialsDTO;
import se.lexicon.model.entity.UserCredentials;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.UserCredentialsFactoryService;

@Component
public class UserDetailsFactoryServiceImpl implements UserCredentialsFactoryService {

    private final ModelMapper modelMapper;

    @Autowired
    public UserDetailsFactoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserCredentialsDTO convertToDTO(UserCredentials userCredentials) {
        return modelMapper.map(userCredentials, UserCredentialsDTO.class);
    }
}
