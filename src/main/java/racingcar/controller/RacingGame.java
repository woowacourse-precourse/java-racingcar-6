package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;

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
    }
}