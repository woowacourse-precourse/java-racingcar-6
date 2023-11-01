package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.car.GameRound;
import racingcar.view.InputView;

public class RacingGameController {

    private Cars cars;
    private GameRound gameRound;

    public RacingGameController() {
    }

    public void run() {
        initCarNames(InputView.readCarName());
        initGameRound(InputView.readGameRound());
    }

    private void initCarNames(final List<String> names) {
        cars = new Cars(names);
    }

    private void initGameRound(final int count) {
        gameRound = new GameRound(count);
    }
}
