package racingcar.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateRepetitionOfCarNames(carNames);

        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void validateRepetitionOfCarNames(List<String> carNames) {
        Set<String> repetitionRemovedCarNames = new HashSet<>(carNames);

        if (repetitionRemovedCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Integer> getMovingDistances() {
        return cars.stream()
            .map(Car::getTotalMovingDistance)
            .collect(Collectors.toList());
    }

    public int getMaximumMovingDistance() {
        return cars.stream()
            .mapToInt(Car::getTotalMovingDistance)
            .max()
            .orElse(0);
    }
}
