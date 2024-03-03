package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.*;
import racingcar.view.*;

public class RacingGame {
    private List<Car> cars;
    private int round;

    public RacingGame() {
        round = 0;
        cars = new ArrayList<>();
    }

    public void play() {
        initCars();
        initTryCount();
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.decideMove();
            }
            OutputView.printRoundResult(cars);
        }
        Referee referee = new Referee(cars);
        List<Car> winners = referee.judgeWinners();
        OutputView.printWinners(winners);
    }

    private void initCars() {
        String[] carNames = InputView.inputCarNames().split(",");
        for (String carName : carNames) {
            try {
                Validator.validateSize(carName);
                cars.add(Car.createCar(carName));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void initTryCount() {
        try {
            round = InputView.inputTryCount();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
