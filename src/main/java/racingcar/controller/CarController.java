package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarController {

    public List<Car> makeCar(String name) {
        ArrayList<Car> cars = new ArrayList<>();

        for (String s : name.split(",")) {
            Car car = new Car(s);
            cars.add(car);
        }
        return cars;
    }
}
