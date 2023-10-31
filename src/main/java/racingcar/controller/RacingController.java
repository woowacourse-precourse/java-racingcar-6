package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final List<Car> cars = new ArrayList<>();
    private int attemptCount = 0;
    private int maxPosition = 0;
    private String winner = "";

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        readyForRacing();
        racing();
        awards();
    }

    private void awards() {
        findWinners();
        outputView.printWinnersMessage(winner);
    }

    private void racing() {
        ResultMessage();
        driveRepeatExecution();
    }

    private void readyForRacing() {
        startInput();
        carsSetting();
    }

    private void ResultMessage() {
        outputView.printSpaceLine();
        outputView.printExecutionResultMessage();
    }

    private void findWinners() {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                makeListOfWinners(car);
            }
        }
    }

    private void makeListOfWinners(Car car) {
        if (winner.isEmpty()) {
            winner = car.getName();
        } else {
            winner += ", " + car.getName();
        }
    }

    private void driveRepeatExecution() {
        while (attemptCount < inputView.getNumberOfAttempts()) {
            carsIterator();
            outputView.printSpaceLine();
            attemptCount++;
        }
    }

    private void carsIterator() {
        for (Car car : cars) {
            isMove(car);
            isMaxPosition(car);
            outputView.printNameAndResultMessage(car.getName(), car.getPosition());
        }
    }

    private void isMaxPosition(Car car) {
        maxPosition = Math.max(maxPosition, car.getPosition());
    }

    private static void isMove(Car car) {
        int number = RandomNumberGenerator.createRandomNumber();
        if (number >= 4) {
            car.move();
        }
    }

    private void carsSetting() {
        for (String name : inputView.getInputNames()) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void startInput() {
        outputView.printCarNamesInputMessage();
        inputView.setInputNames();
        outputView.printExecutionNumberInputMessage();
        inputView.setNumberOfAttempts();
    }
}
