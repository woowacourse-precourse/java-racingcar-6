package racingcar.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Judgement {
    public List<String> selectWinner(List<String> cars, List<Integer> distanceOfCars) {
        int farthestDistance = Collections.max(distanceOfCars);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (distanceOfCars.get(i) == farthestDistance) {
                winners.add(cars.get(i));
            }
        }
        return winners;
    }
}
