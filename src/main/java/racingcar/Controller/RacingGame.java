package racingcar.Controller;

import racingcar.domain.Cars;
import racingcar.util.RandomMoving;

import java.util.List;

import static racingcar.view.InputView.setAttempt;
import static racingcar.view.InputView.setCarNames;

public class RacingGame {
    private Cars cars;
    private RandomMoving movingStrategy = new RandomMoving();

    public void start() throws IllegalArgumentException {
        initRacingCarGame();
    }

    private void initRacingCarGame() throws IllegalArgumentException {
        List<String> carNames = setCarNames();
        cars = new Cars(carNames);

        String attempt = setAttempt();
    }
}
