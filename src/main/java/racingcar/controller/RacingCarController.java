package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingMachine;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
    private RacingMachine racingMachine;

    public void run() {
        setting();
    }

    private void setting() {
        List<String> carNames = InputView.readCarName();
        List<Car> cars = carNames.stream().map(Car::new).toList();
        int moveCount = InputView.readMoveCount();
        racingMachine = new RacingMachine(cars, moveCount);
    }
}
