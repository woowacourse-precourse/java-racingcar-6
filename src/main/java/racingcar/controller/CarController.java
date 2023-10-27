package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.verifier.InputVerifier;
import racingcar.view.InputHandler;

public class CarController {
    private final List<Car> carList = new ArrayList<>();

    public CarController() {
        createCars(InputHandler.inputCars());
    }

    private void createCars(String userInput) {
        InputVerifier.verifyName(userInput);
        List<String> separated = List.of(userInput.split(","));
        separated.forEach(i -> carList.add(new Car(i)));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
