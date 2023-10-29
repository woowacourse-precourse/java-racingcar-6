package racingcar.model;

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
}
