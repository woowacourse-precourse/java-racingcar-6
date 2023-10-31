package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;

public class CarService {

    private static final ArrayList<Car> cars = new ArrayList<>();

    public void saveCar(Car car) {
        cars.add(car);
    }
}
