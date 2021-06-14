package se.lexicon.dao.sequencers;

import se.lexicon.dao.interfaces.UserCredentialsIdSequencer;

public class UserCredentialsIdSequencerImpl implements UserCredentialsIdSequencer {

    private int number;

    @Override
    public int nextId() {
        return ++number;
    }

    @Override
    public void reset() {
        number = 0;
    }

    @Override
    public void set(int i) {
        number = i;
    }

    @Override
    public int get() {
        return number;
    }
}
