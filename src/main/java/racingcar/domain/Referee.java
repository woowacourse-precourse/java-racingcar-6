package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public List<String> findWinner(List<String> cars, List<Integer> carPos) {
        List<String> winner = new ArrayList<>();

        Integer maxPos = Collections.max(carPos);
        for (int i = 0; i < carPos.size(); i++) {
            if (carPos.get(i) == maxPos) {
                winner.add(cars.get(i));
            }
        }

        return winner;
    }
}
