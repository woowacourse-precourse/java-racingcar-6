package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.IntGenerator;

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

    public List<CarState> collectAllCurrentState() {
        return cars.stream()
                .map(Car::summarizeCurrentState)
                .toList();
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
