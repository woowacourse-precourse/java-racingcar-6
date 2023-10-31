package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.CarNameValidator;
import racingcar.util.Constant;
import racingcar.util.RoundCountValidator;

import java.util.Arrays;
import java.util.List;

public class InputController {

    public List<Car> setCarNames(String carNames) {
        new CarNameValidator(carNames);
        return Arrays.stream(carNames.split(Constant.CAR_NAME_DELIMITER)).map(Car::new).toList();
    }

    public int setRoundCount(String roundCountString) {
        new RoundCountValidator(roundCountString);
        return Integer.parseInt(roundCountString);
    }
}
