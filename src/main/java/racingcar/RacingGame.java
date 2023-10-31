package racingcar;

import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingGame {
    private static final int END_COUNT = 0;

    private Cars cars;
    private int attemptCount;

    public RacingGame() {
        this.attemptCount = 0;
    }

    public void initRacingGame() {
        String[] carNames = getCarNames();

        cars = new Cars(carNames);

        attemptCount = getAttemptCount();
    }

}
