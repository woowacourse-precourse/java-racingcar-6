package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {
    private final List<Car> racingCars = new ArrayList<>();
    private final InputView inputView = new InputView();

    public List<String> inputToCarNameList() {
        String playerInput = inputView.getCarNameInput();
        return Arrays.asList(playerInput.split(","));
    }

    public List<Car> getRacingCars() {
        for (String carName : inputToCarNameList()) {
            racingCars.add(new Car(carName));
        }
        return racingCars;
    }
}
