package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;

public class RaceCarEnroller {
    public LinkedHashSet<Car> enrollCars(List<String> validatedCarNames) {
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (String validatedCarName : validatedCarNames) {
            cars.add(new Car(validatedCarName));
        }
        return cars;
    }
}
