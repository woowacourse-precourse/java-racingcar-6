package racingcar.controller;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> carList;

    public Game() {
        this.carList = new ArrayList<>();
    }

    public static Game create() {
        return new Game();
    }

    public void makeCarList(List<String> carList) {

        for (String carName : carList) {
            Car car = Car.create(carName);
            this.carList.add(car);
        }

    }

}
