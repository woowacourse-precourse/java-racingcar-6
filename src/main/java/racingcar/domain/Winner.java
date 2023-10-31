package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final static List<String> winnerList = new ArrayList<>();

    public void init(String name) {
        winnerList.add(name);
    }

    public String toString() {
        String[] array = winnerList.toArray(String[]::new);
        return String.join(", ", array);
    }
}
