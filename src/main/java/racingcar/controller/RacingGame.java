package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars = new Cars();
    private final List<Car> finalWinners = new ArrayList<>();
    private int attemptCount;

    public void start() {
        registerCars();
        inputAttemptCount();

        play();
    }

    private void registerCars() {
        String carNames = InputView.carNames();

        cars.registerCars(carNames);
    }


    public void trimSpaces(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
    }

    private void inputAttemptCount() {
        String count = InputView.attemptCount();

        checkNaturalNumber(count);

        setAttemptCount(Integer.parseInt(count));
    }

    private void checkNaturalNumber(String count) {
        Validator.checkNumber(count);
        Validator.isPositiveNum(Integer.parseInt(count));
    }

    private void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void play() {
        OutputView.exeutionResult();
        for (int i = 0; i < attemptCount; i++) {
            Round.play(cars.getCars());
        }

        decideWinner();
        OutputView.finalWinner(finalWinners);
    }

    private void decideWinner() {
        int maxPosition = -1;

        for (Car car : cars.getCars()) {
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
