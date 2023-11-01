package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.view.InputView.*;

public class GameController {

    public void run() {
        Cars cars = new Cars(List.of(getRacingCarName().split(",")));
        int attemptNumber = getAttemptNumber();

        OutputView.printExecuteMessage();

        for (int i = 0; i < attemptNumber; i++) {
            cars.move();
            OutputView.printResult(cars.getCars());
        }
    }
}
