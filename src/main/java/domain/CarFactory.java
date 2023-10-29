package domain;

import domain.Car;
import domain.CarEngine;
import infra.RandomCarEngine;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {

    private final CarEngine carEngine;

    public CarFactory(final CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public List<Car> generateCars(final List<String> carNames) {
        validateNoDuplicatedNames(carNames);
        return carNames.stream().map(name -> new Car(name, carEngine)).toList();
    }

    private void validateNoDuplicatedNames(final List<String> carNames) {
        final Set<String> setNames = new HashSet<>(carNames);
        if (carNames.size() != setNames.size()) {
            throw new IllegalArgumentException();
        }
    }
}
