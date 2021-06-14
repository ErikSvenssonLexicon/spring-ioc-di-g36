package se.lexicon.service.factory.interfaces;

import se.lexicon.model.dto.TodoItemDTO;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.TodoItem;

public interface TodoItemFactoryService {
    TodoItemDTO convertToDTO(TodoItem todoItem);
    TodoItemDTOBasic convertToBasicDTO(TodoItem person);
}
