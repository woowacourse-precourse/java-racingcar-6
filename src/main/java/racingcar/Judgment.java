package racingcar;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Judgment {
    public Integer findMaxPosition(List<Car> carList) {
        Set<Integer> positionSet = new HashSet<>();
        for (Car car : carList) {
            positionSet.add(car.getPosition());
        }
        return Collections.max(positionSet);
    }
}
