package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {

    private final RacingService racingService = new RacingService();

    public List<Car> createCarList(String[] carNames) {
        return racingService.createCarList(carNames);
    }

    public List<Car> playSingleRound(List<Car> cars) {
        return racingService.playSingleRound(cars);
    }

    public List<String> readVictoryPlayers(List<Car> cars) {
        return racingService.findByVictoryPlayers(cars);
    }
}
