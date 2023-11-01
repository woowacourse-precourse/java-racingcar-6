package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;
    public RacingCarController(RacingCarService racingCarService) { this.racingCarService = racingCarService; }

    public void start() {
        List<RacingCar> cars = racingCarService.makeCars();
        int raceCount = racingCarService.getRaceCount();
        List<RacingCar> racedCars = racingCarService.racingGame(cars, raceCount);
        racingCarService.calculateRacingWinner(racedCars);
    }
}
