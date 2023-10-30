package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.printGameNotice;
import static racingcar.view.OutputView.printRoundResult;
import static racingcar.view.OutputView.printWinners;
import static racingcar.view.constants.GameNotice.EXECUTION_RESULT;


import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Number;

public class GameController {
    private final List<Car> cars = new ArrayList<>();
    private Number round;
    private Referee referee;

    public void play() {
        setUp();
        printGameNotice(EXECUTION_RESULT);
        while(round.hasRemainRound()) {
            referee.proceedRound();
            printRoundResult(cars);
        }
        printWinners(referee.determineWinner());
    }

    private void setUp() {
        List<String> userInput = askCarNames();
        createCars(userInput);
        round = Number.inputUserRounds();
        referee = Referee.of(cars);
    }

    private void createCars(List<String> userInput) {
        for (String carName : userInput) {
            cars.add(Car.createCar(carName));
        }
    }
}
