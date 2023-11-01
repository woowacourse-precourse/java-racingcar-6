package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {
    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
