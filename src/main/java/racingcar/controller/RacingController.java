package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {

    public void startRacing() {
        String carNames = RacingService.getCarNames();
        List<Car> cars = RacingService.createCars(carNames);
        int moveCount = RacingService.getMoveCount();
    }
}
