package racingcar.service;

import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.validator.AttemptCountValidator;

public class GamePlayingService {
    private final RacingGame racingGame;

    public GamePlayingService(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void generateCars(String inputNames) {
        racingGame.generateCars(inputNames);
    }

    public AttemptCount createAttemptCount(String input) {
        AttemptCountValidator.INSTANCE.validate(input);

        return new AttemptCount(toInt(input));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public void tryForward() {
        racingGame.tryForward();
    }

    public CarsState getCarsState() {
        return racingGame.getCarsState();
    }

    public Winners getWinners() {
        return racingGame.getWinners();
    }
}
