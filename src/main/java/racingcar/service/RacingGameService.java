package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;

public class RacingGameService {

    public OneGameResultDto playOneTimeCarRace(RacingCars cars) {
        List<Car> endCars = cars.doRace();
        return new OneGameResultDto(endCars);
    }
}
