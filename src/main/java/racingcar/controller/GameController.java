package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Car> cars = new ArrayList<>();

    public void setUp(String names) {
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }
}


