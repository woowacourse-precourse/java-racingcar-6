package racingcar.service;

import racingcar.domain.CarsDto;
import racingcar.domain.RacingCars;

public class RacingService {
    RacingCars racingCars;

    public RacingService(CarsDto carsDto) {
        this.racingCars = new RacingCars(carsDto);
    }
}
