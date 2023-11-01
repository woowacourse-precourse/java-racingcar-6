package racingcar.validator;

import racingcar.domain.Car;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    private final static int LENGTH_STANDARD = 5;

    public void checkCarName(String name) {
        checkLength(name);
        checkNonBlank(name);
    }

    private void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Length must be less or equal than" + LENGTH_STANDARD);
        }
    }

    private void checkNonBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Car name cannot be blank");
        }
    }

    public void checkDuplicateName(List<Car> carList) {
        Set<String> nameSet = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carList.size() != nameSet.size()) {
            throw new IllegalArgumentException("Name must not be duplicated");
        }
    }

    public int checkTryCountInput(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("Try count input is invalid");
        }

        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Try count input is invalid");
        }
    }
}
