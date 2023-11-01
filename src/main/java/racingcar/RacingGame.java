package racingcar;

import java.util.List;

public class RacingGame {
    public void startGame() {
        OutputView.printAskCarNames();
        List<Car> cars = InputView.inputCarsInfo();

        OutputView.printAskRound();
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
