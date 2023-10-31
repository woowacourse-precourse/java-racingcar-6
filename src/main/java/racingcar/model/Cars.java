package racingcar.model;

import static racingcar.model.CarNameValidator.carNameValidation;

import java.util.Comparator;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        carNameValidation(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Car winner() {
        Car win = cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElse(null);
        return win;
    }
}
