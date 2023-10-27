package racingcar.controller;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Car> cars = new ArrayList<>();
    private List<String> raceHistory = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            String roundResult = "";
            for (Car car : cars) {
                car.move();
                roundResult += car.getName() + " : " + car.getPositionString() + "\n";
            }
            raceHistory.add(roundResult);
        }
    }
}
