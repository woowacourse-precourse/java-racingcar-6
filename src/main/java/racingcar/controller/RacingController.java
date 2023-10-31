package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;

import java.util.List;
import java.util.Map;

public class RacingController {

    private final RacingService racingService = new RacingService();

    public List<Car> createCarList(String[] carNames) {
        return racingService.createCarList(carNames);
    }

    public Map<String, Integer> playRacing(List<Car> cars) {
        return racingService.playSingleRound(cars);
    }

    public List<String> readVictoryPlayers(List<Car> cars) {
        return racingService.findByVictoryPlayers(cars);
    }
}
