package racingcar.model;

import static racingcar.common.Config.RACING_COUNT_CHARACTER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCarMovement {
    private final List<Integer> countCarMovement;

    private CountCarMovement(Integer size) {
        this.countCarMovement = new ArrayList<>(Collections.nCopies(size, 0));

    }

    public static CountCarMovement createCountCarMovement(Integer size) {
        return new CountCarMovement(size);
    }

    public void forwardCar (Integer index) {
        countCarMovement.set(index, countCarMovement.get(index) + 1);
    }

    public String toString (Integer index) {
        return RACING_COUNT_CHARACTER.repeat(Math.max(0, countCarMovement.get(index)));
    }

    public List<Integer> winnersIndex() {
        List<Integer> winners = new ArrayList<>();

        for (int i = 0; i < countCarMovement.size(); i++) {
            if (Collections.max(countCarMovement).equals(countCarMovement.get(i))) {
                winners.add(i);
            }
        }

        return winners;
    }
}
