package racingcar.service;

import java.util.ArrayList;
import racingcar.model.Car;

public class CarService {

    private static final ArrayList<Car> cars = new ArrayList<>();

    public void saveCar(Car car) {
        cars.add(car);
    }
}