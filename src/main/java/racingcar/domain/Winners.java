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
        if (names.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder(names.get(0));

        for (int i = 1; i < names.size(); i++) {
            result.append(",").append(names.get(i));
        }

        return result.toString();
    }

}
