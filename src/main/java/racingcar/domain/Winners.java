package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> names;

    public Winners() {
        names = new ArrayList<>();
    }

    public void addNameOfWinner(final String name) {
        names.add(name);
    }

    @Override
    public String toString() {
        if (names.size() == 1) {
            return names.get(0);
        }

        String result = "";
        for (String name : names) {
            result = result + ", " + name;
        }
        return result;
    }
}
