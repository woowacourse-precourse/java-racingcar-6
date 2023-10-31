package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    List<Integer> forwardNumber = new ArrayList<>();
    public void countBar(Car car) {
        forwardNumber.add(car.movement.size());
    }
}
