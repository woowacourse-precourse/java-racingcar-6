package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private Cars cars;
    private Round round;

    public RacingGameController(){
        playGame();
        showWinners();
    }

    public void playGame() {
        cars = new Cars(InputView.inputNames());
        round = new Round(InputView.inputRound());

        OutputView.printExecutionResultMessage();

        IntStream.range(0, round.round)
                .forEach(i -> runRound());
    }

    private void runRound() {
        cars.getCarList().forEach(Car::moveForward);
        cars.getCarList().forEach(OutputView::printCarNameAndPosition);
        System.out.println();
    }

    private void showWinners() {
        OutputView.printWinners(cars.getWinners());
    }
}
