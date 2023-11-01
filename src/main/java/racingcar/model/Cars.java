package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.IntGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public Cars(List<String> names, IntGenerator intGenerator) {
        validateDuplicateName(names);
        this.cars = names.stream()
                .map(name -> new Car(name, intGenerator))
                .toList();
    }

    public List<CarState> collectAllState() {
        return cars.stream()
                .map(Car::summarizeState)
                .toList();
    }

    public List<String> findAllNameByForwardCount(int targetForwardCount) {
        return cars.stream()
                .filter(car -> car.hasForwardCountOf(targetForwardCount))
                .map(Car::getName)
                .toList();
    }

    public int calculateMaxForwardCount() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }

    public void move() {
        cars.forEach(Car::tryForward);
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NAME.getMessage());
        }
    }
}
