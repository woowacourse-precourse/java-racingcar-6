package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingReferee {
    private RacingReferee() {

    }

    public static List<Car> determineWinners(Cars cars) {
        return cars.getCarsWithMaxStep();
    }
}
