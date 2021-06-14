package se.lexicon.dao.interfaces;

public interface UserCredentialsIdSequencer {
    int nextId();
    void reset();
    void set(int i);
    int get();
}
