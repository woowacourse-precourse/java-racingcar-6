package racingcar.service;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.RacingCars;

public class GameService {

    private final RacingCarService racingCarService = new RacingCarService();

    public Game createGame(List<String> racingCarNames, int totalAttempts) {
        RacingCars racingCars = racingCarService.createRacingCars(racingCarNames);
        return new Game(racingCars, totalAttempts);
    }

}
