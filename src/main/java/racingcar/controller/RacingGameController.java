package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Judgment;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Judgment judgment;
    private final Referee referee;

    public RacingGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        judgment = new Judgment();
        referee = new Referee();
    }

    public void run() {
        List<Car> cars = receiveCars();
        int tryCount = receiveTryCount();

        playCarRacing(cars, tryCount);
    }

    private List<Car> receiveCars() {
        outputView.printCarInputMessage();
        final List<String> carNames = inputView.askCarNames();

        List<Car> cars = convertToCars(carNames);
        return cars;
    }

    private List<Car> convertToCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int receiveTryCount() {
        outputView.printTryCountInputMessage();
        int tryCount = inputView.askTryCount();
        return tryCount;
    }

    private void playCarRacing(List<Car> cars, int tryCount) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            printCarsInfo(cars);
            outputView.printNewLine();
        }
        processResult(cars);
    }

    private void printCarsInfo(List<Car> cars) {
        for (Car car : cars) {
            outputView.printCarInfo(car);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (judgment.canMove(NumberGenerator.createRandomNumber())) {
                car.move();
            }
        }
    }

    private void processResult(List<Car> cars) {
        List<Car> winners = referee.getWinner(cars);
        outputView.printWinner(winners);
    }
}
