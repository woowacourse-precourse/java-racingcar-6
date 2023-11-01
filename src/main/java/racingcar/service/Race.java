package racingcar.service;

import racingcar.console.Input;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars = new ArrayList<>();

    public void start() {
        initializeCars();
    }

    private void initializeCars() {
        String carNames = Input.getCarNames();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name.trim()));
        }
    }
}
