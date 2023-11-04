package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private static final String SEPERATOR = ", ";

    private final List<Name> winner;

    public Winner() {
        winner = new ArrayList<>();
    }

    @Override
    public String toString() {

        StringBuilder message = new StringBuilder();

        for (int i = 0; i < winner.size(); i++) {

            String name = winner.get(i).getName();
            message.append(name);

            if (i != (winner.size() - 1)) {
                message.append(SEPERATOR);
            }
        }

        return message.toString();
    }

    public void add(Name name) {
        winner.add(name);
    }

    public void clear() {
        winner.clear();
    }

}
