package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Judgment {
    List<Integer> forwardNumber = new ArrayList<>();
    static int maxBar = 0;

    public void countBar(Car car) {
        forwardNumber.add(car.movement.size());
    }

    public void compareMovement(List<Integer> forwardNumber) {
        maxBar = Collections.max(forwardNumber);
    }
}
