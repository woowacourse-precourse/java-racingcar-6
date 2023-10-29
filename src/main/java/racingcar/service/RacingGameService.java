package racingcar.service;

import java.util.List;
import racingcar.service.domain.Car;
import racingcar.service.domain.RacingCars;

public class RacingGameService {

    public OneGameResultDto playOneTimeCarRace(RacingCars cars) {
        List<Car> endCars = cars.doRace();
        return new OneGameResultDto(endCars);
    }
}
