package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.printGameNotice;
import static racingcar.view.OutputView.printRoundResult;
import static racingcar.view.OutputView.printWinners;
import static racingcar.view.constants.GameNotice.EXECUTION_RESULT;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RoundCount;

public class GameController {
    private final List<Car> cars = new ArrayList<>();
    private RoundCount roundCount;
    private Referee referee;

    public void play() {
        setUp();
        printGameNotice(EXECUTION_RESULT);

        while (roundCount.hasRemain()) {
            referee.proceedRound();
            printRoundResult(cars);
        }
        printWinners(referee.determineWinner());
    }

    private void setUp() {
        List<String> userInputCarNames = askCarNames();
        createCars(userInputCarNames);

        String userInputRoundCount = askHowManyRounds();
        roundCount = RoundCount.store(userInputRoundCount);

        referee = Referee.of(cars);
    }

    private void createCars(List<String> userInput) {
        for (String carName : userInput) {
            cars.add(Car.create(carName));
        }
    }
}
