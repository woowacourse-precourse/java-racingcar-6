package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Judgment {
    public int findMaxPosition(List<Car> carList, int totalRounds) {
        Set<Integer> positionSet = new HashSet<>();

        for (Car car : carList) {
            positionSet.add(car.getPosition());
        }

        int i;
        for (i = 0; i < totalRounds; i++) {
            if (positionSet.contains(totalRounds - i)) {
                break;
            }
        }
        return totalRounds - i;
    }
}
