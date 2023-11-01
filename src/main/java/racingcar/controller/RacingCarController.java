package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        List<Car> cars = inputCarNames();
        int attemptNumber = inputAttemptNumber();
        printResult(attemptNumber, cars);
        printWinners(cars);
    }

    private List<Car> inputCarNames() {
        outputView.printStartGameMessage();
        List<String> carNames = inputView.inputCarNames();
        List<Car> cars = racingCarService.convertCarNames(carNames);
        return cars;
    }

    private int inputAttemptNumber() {
        outputView.printAttempNumMessage();
        int attemptNumber = inputView.inputAttemptNumber();
        return attemptNumber;
    }

    private void printResult(int attemptNumber, List<Car> cars) {
        outputView.printResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            racingCarService.raceCar(cars);
            outputView.printAttempResult(cars);
        }
    }

    private void printWinners(List<Car> cars) {
        List<Car> winners = racingCarService.calculatWinner(cars);
        outputView.printWinners(winners);
    }
}
