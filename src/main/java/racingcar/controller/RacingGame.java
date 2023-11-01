package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;
    private final int round;

    public RacingGame(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void startGame() {
        OutputView.printExecutionResultText();

        for (int count = 1; count <= round; count++) {
            proceedRound();
            OutputView.printNewLine();
        }
        OutputView.printWinners(cars);
    }

    private void proceedRound() {
        cars.forEach(Car::move);
        cars.forEach(OutputView::printRoundResult);
    }
}
