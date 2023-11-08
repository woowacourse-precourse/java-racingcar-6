package racingcar.domain.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.config.GameConfig;
import racingcar.domain.entity.Car;

public class CarNameValidator {
    private static final int MAXIMUM_NAME = GameConfig.MAXIMUM_NAME;
    private static final String NAME_TOO_LONG_ERROR_MESSAGE = "The name must be less than %d characters.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "Car name duplicate";

    public static void validate(String name) {
        checkMaximumName(name);
    }

    private static void checkMaximumName(String name) {
        if (name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException(String.format(NAME_TOO_LONG_ERROR_MESSAGE, (MAXIMUM_NAME + 1)));
        }
    }

    public static void checkDuplication(List<Car> cars) {
        Set<Car> uniqueCar = new HashSet<>(cars);

        if (cars.size() != uniqueCar.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }
}
