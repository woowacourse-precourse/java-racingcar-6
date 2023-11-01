package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class GameController {

    public void run() {
        Cars cars = new Cars(List.of(getRacingCarName().split(",")));
        int attemptNumber = getAttemptNumber();

        printExecuteMessage();

        for (int i = 0; i < attemptNumber; i++) {
            cars.move();
            printResult(cars.getCars());
        }

        printWinner(cars.findWinner());
    }
}
