package racingcar.domain;

import java.util.List;

public class Referee {

    public List<Car> decideWinners(Cars cars) {
        int maxForwardCount = cars.getMaxForwardCountOfCars();
        return cars.getCarsWithMaxForwardCount(maxForwardCount);
    }
}
