package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.RacingcarView;

import java.util.Map;

public class RacingcarController {
    private final Cars cars;
    private final Validation validation;
    private final RacingcarView racingcarView;

    public RacingcarController(Cars cars, Validation validation, RacingcarView racingcarView) {
        this.cars = cars;
        this.validation = validation;
        this.racingcarView = racingcarView;
    }

    public void runGame() {
        String inputCarName = "";
        String inputNumber = "";

        inputCarName = racingcarView.inputName();
        inputNumber = racingcarView.inputNumber();

        if (!validation.validationNames(inputCarName)) {
            throw new IllegalArgumentException();
        }
        if (!validation.validationNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }

        Map<String, Car> carList = cars.makeCarList(inputCarName);
    }

}
