package se.lexicon.dao.interfaces;

public interface PersonIdSequencer {
    int nextId();
    void reset();
    void set(int i);
    int get();
}
