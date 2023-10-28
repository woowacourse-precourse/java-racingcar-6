package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public List<Car> judge(List<Car> cars) {
        int maxForwardCount = 0;
        for (Car car : cars) {
            maxForwardCount = car.getLargerForwardCount(maxForwardCount);
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isForwardCountSameAs(maxForwardCount)) {
                winners.add(car);
            }
        }

        return winners;
    }
}
