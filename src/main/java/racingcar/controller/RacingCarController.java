package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void startGame() {
        List<Car> cars = inputCarNames();
        int attempNumber = inputAttempNumber();
        printResult(attempNumber, cars);
        printWinners(cars);
    }

    private List<Car> inputCarNames() {
        OutputView.printStartGameMessage();
        List<String> carNames = InputView.inputCarNames();
        List<Car> cars = RacingCarService.convertCarNames(carNames);
        return cars;
    }

    private int inputAttempNumber() {
        OutputView.printAttempNumMessage();
        int attempNumber = InputView.inputAttempNum();
        return attempNumber;
    }

    private void printResult(int attempNumber, List<Car> cars) {
        OutputView.printResultMessage();
        for (int i = 0; i < attempNumber; i++) {
            RacingCarService.raceCar(cars);
            OutputView.printAttempResult(cars);
        }
    }

    private void printWinners(List<Car> cars) {
        List<Car> winners = RacingCarService.calculatWinner(cars);
        OutputView.printWinners(winners);
    }
}
