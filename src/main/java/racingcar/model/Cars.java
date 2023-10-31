package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void createCars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }
}
