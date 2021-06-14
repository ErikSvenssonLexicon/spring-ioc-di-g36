package se.lexicon.dao.interfaces;

import java.util.Collection;
import java.util.Optional;

public interface GenericCRUD <T, ID>{

    T persist(T entity);
    Optional<T> findById(ID id);
    Collection<T> findAll();
    void remove(T entity);

}
