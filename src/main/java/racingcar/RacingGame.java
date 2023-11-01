package racingcar;

import java.util.List;

public class RacingGame {
    public void startGame() {
        List<Car> cars = InputView.inputCarsInfo();
        int round = InputView.inputRound();

        OutputView.printExecutionResultText();

        for (int count = 1; count <= round; count++) {
            proceedRound(cars);
        }
        OutputView.printWinners(cars);
    }

    private void proceedRound(List<Car> cars) {
        cars.forEach(Car::move);
        cars.forEach(OutputView::printRoundResult);
    }
}
