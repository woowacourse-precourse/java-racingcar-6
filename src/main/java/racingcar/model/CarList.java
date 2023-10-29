package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Validator.Validator.*;

public class CarList {
    private final List<Car> cars;

    public CarList(String allCarNames) {

        this.cars = Arrays.stream(allCarNames.split(","))
                .map(this::createCar)
                .collect(Collectors.toList());
    }

    private Car createCar(String name) {
        validateNotBlank(name);
        validateLengthInRange(name);
        return new Car(name);
    }

    public List<Car> getCars() {
        return cars;
    }
}
