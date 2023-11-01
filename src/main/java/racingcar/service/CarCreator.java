package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.Car;

public class CarCreator {


    public List<Car> createCars(List<String> rangeCarList, int distance) {
        List<Car> cars = new ArrayList<>();
        for (String name : rangeCarList) {
            cars.add(new Car(name, distance));
        }
        return cars;

    }

}
