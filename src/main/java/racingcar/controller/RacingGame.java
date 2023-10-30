package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        List<String> racingCarNames = InputView.readRacingCarName();
        List<Car> cars = new ArrayList<>();
        Validator.validateIsDuplicate(racingCarNames);
        for (String name : racingCarNames) {
            Validator.validateUnderFiveLength(name);
            Validator.validateIsBlank(name);
            cars.add(new Car(name));
        }

        Long tryCount = InputView.readTryCount();

        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            tryToMoveCars(cars);
            OutputView.printResult(cars);
        }
    }

    private void tryToMoveCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveOrStay();
        }
    }
}