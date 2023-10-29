package domain;

import domain.Car;
import domain.CarEngine;
import infra.RandomCarEngine;
import java.util.List;

public class CarFactory {

    private final CarEngine carEngine;

    public CarFactory(final CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public List<Car> generateCars(final List<String> carNames) {
        return carNames.stream().map(name -> new Car(name, carEngine)).toList();
    }
}
