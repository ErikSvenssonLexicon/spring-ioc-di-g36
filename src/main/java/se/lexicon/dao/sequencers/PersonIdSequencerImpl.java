package se.lexicon.dao.sequencers;

import org.springframework.stereotype.Component;
import se.lexicon.dao.interfaces.PersonIdSequencer;

@Component
public class PersonIdSequencerImpl implements PersonIdSequencer {

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
