package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputHandler;

public class CarController {
    List<Car> carList = new ArrayList<>();

    CarController() {
        createCars(InputHandler.inputCars());
    }

    void createCars(String userInput) {
        List<String> separated = List.of(userInput.split(","));
        separated.forEach(i -> carList.add(new Car(i)));
    }
}
