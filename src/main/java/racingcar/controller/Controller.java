package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Result;
import racingcar.util.ResultMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final List<Car> cars;

    public Controller() {
        this.cars = new ArrayList<>();
    }

    public void play() {
        settingCarName();
        runGame();
        displayFinalResult();
    }

    private void displayFinalResult() {
        Result result = new Result(cars);
        OutputView.printlnConsoleMessage(result.getWinners());
    }

    private void runGame() {
        int attemptCount = InputView.inputAttemptCount();
        OutputView.printlnConsoleMessage(ResultMessage.EXECUTION_RESULT);
        while (attemptCount-- > 0) {
            playRound();
            OutputView.printlnNewLine();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
        for (Car car : cars) {
            OutputView.printlnConsoleMessage(car.getRecord());
        }
    }

    private void settingCarName() {
        String[] carNames = InputView.inputCarName();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
