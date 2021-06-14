package se.lexicon.service.interfaces;

import se.lexicon.dao.interfaces.GenericCRUD;
import se.lexicon.model.dto.TodoItemDTO;
import se.lexicon.model.dto.TodoItemDTOBasic;
import se.lexicon.model.entity.TodoItem;

import java.math.BigDecimal;
import java.util.List;

public interface TodoItemService  {

    TodoItem create(String topic, String description, BigDecimal payment, String ownerUsername);

    TodoItemDTO findById(int id);

    List<TodoItemDTOBasic> findAll();

    TodoItem update(int id, TodoItemDTO todoItemDTO);

    TodoItemDTO addAssignee(int personId, int todoId);

    TodoItemDTO removeAssignee(int personId, int todoId);

    void remove(int id);

}
