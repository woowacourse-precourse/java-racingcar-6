package racingcar.controller;

import java.util.List;

import racingcar.MoveResult;
import racingcar.utils.NumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final NumberGenerator numberGenerator;

    public GameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = createCars();
        NumberOfAttempts numberOfAttempts = createNumberOfAttempts();
        playRacing(cars, numberOfAttempts);
        decideWinners(cars);
    }

    private Cars createCars() {
        List<String> carNames = InputView.readCarNames();
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    private NumberOfAttempts createNumberOfAttempts() {
        return new NumberOfAttempts(InputView.readNumberOfAttempts());
    }

    private void playRacing(Cars cars, NumberOfAttempts numberOfAttempts) {
        OutputView.printRacingResultMessage();
        while (numberOfAttempts.hasRemainingAttempts()) {
            MoveResult moveResult = cars.handleCarMovement(numberGenerator);
            OutputView.printMoveResult(moveResult.carNames(), moveResult.forwardCounts());
            numberOfAttempts.decreaseNumberOfAttempts();
        }
    }

    private void decideWinners(Cars cars) {
        Referee referee = new Referee();
        List<String> winners = referee.decideWinners(cars)
                .stream()
                .map(Car::getName)
                .toList();
        OutputView.printWinners(winners);
    }
}
