package se.lexicon.dao;

import se.lexicon.dao.interfaces.TodoItemDAO;
import se.lexicon.model.entity.TodoItem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TodoItemDAOCollectionImpl implements TodoItemDAO {

    private final Set<TodoItem> storage;

    public TodoItemDAOCollectionImpl() {
        storage = new HashSet<>();
    }

    @Override
    public TodoItem persist(TodoItem entity) {
        if(entity == null) throw new IllegalArgumentException("Persist aborted TodoItem entity was null");
        storage.add(entity);
        return entity;
    }

    @Override
    public Optional<TodoItem> findById(Integer integer) {
        return storage.stream()
                .filter(todoItem -> todoItem.getId() == integer)
                .findFirst();
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new HashSet<>(storage);
    }


    @Override
    public void remove(TodoItem entity) {
        storage.remove(entity);
    }
}
