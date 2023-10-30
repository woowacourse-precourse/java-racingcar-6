package racingcar.controller;

import racingcar.domain.Car;
import racingcar.printer.Input;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    final Integer MOVEMENT = 0;
    final String DASH = "";
    public void runGame() {
        List<String> carList = setCarList();
        int count = setCount();
    }

    private List<String> setCarList() {
        return Input.getCars();
    }

    private int setCount() {
        return Input.gameNumber();
    }

    private List<Car> setCars(List<String> carList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carList) {
            cars.add(new Car(carName, MOVEMENT, DASH));
        }
        return cars;
    }
}
