package racingcar.validator;

import racingcar.domain.Car;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarValidator {
    private final static int LENGTH_STANDARD = 5;

    public void checkCarCount(String[] carNameInput) {
        if (carNameInput.length == 0) {
            throw new IllegalArgumentException("At least one car required");
        }
    }

    public void checkCarName(String name) {
        checkLength(name);
        checkNonBlank(name);
    }

    private void checkLength(String name) {
        if (name.length() > LENGTH_STANDARD) {
            throw new IllegalArgumentException(String.format("Length must be less or equal than %d", LENGTH_STANDARD));
        }
    }

    private void checkNonBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Car name cannot be blank");
        }
    }

    public void checkDuplicate(List<Car> carList) {
        Set<String> nameSet = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carList.size() != nameSet.size()) {
            throw new IllegalArgumentException("Name must not be duplicated");
        }
    }
}
