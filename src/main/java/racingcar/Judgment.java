package racingcar;

import java.util.Collections;
import java.util.HashMap;

public class Judgment {
    Integer firstPosition = 0;

    public void firstCarPosition(HashMap<String, Integer> cars) {
        firstPosition = Collections.max(cars.values());
    }

    public Boolean isWinner(Integer position) {
        return position.equals(firstPosition);
    }
}
