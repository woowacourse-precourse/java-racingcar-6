package racingcar.domain;

import java.util.List;

public class Referee {

    public List<Car> decideWinners(Cars cars) {
        return cars.getCarsWithMaxForwardCount();
    }
}
