package racingcar;

import java.util.List;

public class RacingGame {
    public void startGame() {
        OutputView.printAskCarNames();
        List<Car> cars = InputView.inputCarNames();

        OutputView.printAskRound();
        int round = InputView.inputRound();

        OutputView.printExecutionResultText();
        proceedEachRound(cars, round);
        OutputView.printWinners(cars);
    }

    private void proceedEachRound(List<Car> cars, int totalRound) {
        for (int round = 1; round <= totalRound; round++) {
            proceedRound(cars);
        }
    }

    private void proceedRound(List<Car> cars) {
        cars.forEach(Car::move);
        cars.forEach(OutputView::printRoundResult);
        OutputView.printNewLine();
    }
}
