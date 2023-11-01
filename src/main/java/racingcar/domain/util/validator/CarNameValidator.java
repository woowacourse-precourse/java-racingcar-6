package racingcar.domain.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.config.GameConfig;
import racingcar.domain.entity.Car;

public class CarNameValidator {
    private static final int MAXIMUM_NAME = GameConfig.MAXIMUM_NAME;

    public static void validate(String name) {
        maximumName(name);
    }

    private static void maximumName(String name) {
        if (name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException("The name must be less than " + (MAXIMUM_NAME + 1) + " characters.");
        }
    }

    public static void checkDuplication(List<Car> cars) {
        Set<Car> uniqueCar = new HashSet<>(cars);

        if (cars.size() != uniqueCar.size()) {
            throw new IllegalArgumentException("Car name duplicate");
        }
    }
}
