package se.lexicon.service.factory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.model.dto.PersonDTOBasic;
import se.lexicon.model.dto.TodoItemDTO;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.Person;
import se.lexicon.model.entity.TodoItem;
import se.lexicon.service.factory.interfaces.PersonFactoryService;
import se.lexicon.service.factory.interfaces.TodoItemFactoryService;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoItemFactoryServiceImpl implements TodoItemFactoryService {

    private final ModelMapper modelMapper;

    public TodoItemFactoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TodoItemDTO convertToDTO(TodoItem todoItem) {
        return modelMapper.map(todoItem, TodoItemDTO.class);
    }

    @Override
    public TodoItemDTOBasic convertToBasicDTO(TodoItem todoItem) {
        return modelMapper.map(todoItem, TodoItemDTOBasic.class);
    }
}
