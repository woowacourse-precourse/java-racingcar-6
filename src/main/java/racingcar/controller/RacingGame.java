package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Exception;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final List<Car> finalWinners = new ArrayList<>();
    private int attemptCount;

    public void start() {
        registerCars();
        inputAttemptCount();

        play();
    }

    public void play() {
        OutputView.exeutionResult();

        for (int i = 0; i < attemptCount; i++) {
            Round.play(carList);
        }

        decideWinner();
        OutputView.finalWinner(finalWinners);
    }

    public void registerCars() {
        String carNames = InputView.carNames();
        String[] names = carNames.split(",");

        Exception.isSpace(names);

        for (String name : names) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        Car car = new Car(name);
        carList.add(car);
    }

    public void inputAttemptCount() {
        String count = InputView.attemptCount();
        Exception.checkNumber(count);

        setAttemptCount(Integer.parseInt(count));
    }

    private void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void decideWinner() {
        int maxPosition = -1;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                finalWinners.clear();
                finalWinners.add(car);
            } else if (car.getPosition() == maxPosition) {
                finalWinners.add(car);
            }
        }
    }
}
