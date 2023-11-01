package racingcar.application;

import racingcar.domain.model.Car;
import racingcar.domain.service.RacingGame;

import java.util.List;

public class RacingService {
    private static final RacingService instance = new RacingService();
    private final RacingGame racingGame = RacingGame.getInstance();

    private RacingService() {
    }

    public static RacingService getInstance() {
        return instance;
    }

    public List<Car> playRound(List<Car> cars) {
        racingGame.moveCars(cars);
        return cars;
    }

    public List<Car> getWinners(List<Car> cars) {
        return racingGame.determineWinners(cars);
    }
}