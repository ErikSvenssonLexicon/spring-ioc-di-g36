package se.lexicon.dao.interfaces;

public interface TodoItemIdSequencer {
    int nextId();
    void reset();
    void set(int i);
    int get();
}
