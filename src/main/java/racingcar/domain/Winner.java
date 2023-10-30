package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winnerList = new ArrayList<>();

    public void init(String name) {
        winnerList.add(name);
    }
}
