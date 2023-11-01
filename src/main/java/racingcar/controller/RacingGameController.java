package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;

public class RacingGameController {

    private Cars cars;

    public RacingGameController() {
    }

    public void run() {
        initCarNames(InputView.readCarName());
    }

    private void initCarNames(final List<String> names) {
        cars = new Cars(names);
    }
}
