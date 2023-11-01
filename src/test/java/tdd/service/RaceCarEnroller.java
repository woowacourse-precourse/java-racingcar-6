package tdd.service;

import java.util.LinkedHashSet;
import java.util.List;
import tdd.domain.Car;

public class RaceCarEnroller {
    private final LinkedHashSet<Car> cars = new LinkedHashSet<>();
    public LinkedHashSet<Car> enrollCars(List<String> validatedCarNames) {
        for (String validatedCarName : validatedCarNames) {
            cars.add(new Car(validatedCarName));
        }
        return cars;
    }
}
