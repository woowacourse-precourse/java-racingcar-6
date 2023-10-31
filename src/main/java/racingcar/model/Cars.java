package racingcar.model;

import static racingcar.model.CarNameValidator.carNameValidation;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        carNameValidation(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> winner() {
        List<Car> winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance())
                .collect(Collectors.toList());
        return winners;
    }

    public int maxDistance() {
        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
        return max;
    }
}
