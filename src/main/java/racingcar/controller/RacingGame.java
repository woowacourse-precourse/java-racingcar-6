package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Exception;
import racingcar.view.InputView;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int attemptCount;

    RacingGame() {
    }

    public void start() {
        registerCars();
        inputAttemptCount();
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
}
