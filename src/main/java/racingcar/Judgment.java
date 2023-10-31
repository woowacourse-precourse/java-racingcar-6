package racingcar;

import java.util.ArrayList;
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

    public List<String> getWinnerNames(List<Car> carList, int maxPosition) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : carList) {
            if (maxPosition == car.getPosition()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
