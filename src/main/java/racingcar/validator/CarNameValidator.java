package racingcar.validator;

import racingcar.domain.car.Car;

import java.util.List;

import static racingcar.config.GameConfig.NAME_LENGTH_CONDITION;
import static racingcar.exception.ErrorMessage.*;

public class CarNameValidator {

    private CarNameValidator() {

    }

    public static void validateForInputString(String carNames) {
        validateEmptyForInputString(carNames);
        validateContainsCommaForInputString(carNames);
    }

    private static void validateEmptyForInputString(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_EMPTY_FOR_INPUT_STRING.getMessage());
        }
    }

    private static void validateContainsCommaForInputString(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(VALIDATE_CONTAINS_COMMA_FOR_INPUT_STRING.getMessage());
        }
    }

    public static void validateDuplicateForList(List<Car> cars) {
        if (cars.stream()
                .distinct()
                .count() != cars.size()) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATE_FOR_LIST.getMessage());
        }
    }

    public static void validateForEachName(String carName) {
        validateEmptyForEachName(carName);
        validateLengthForEachName(carName);
    }

    private static void validateEmptyForEachName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_EMPTY_FOR_EACH_NAME.getMessage());
        }
    }

    private static void validateLengthForEachName(String carName) {
        if (carName.length() > NAME_LENGTH_CONDITION.getNumber()) {
            throw new IllegalArgumentException(String.format(VALIDATE_LENGTH_FOR_EACH_NAME.getMessage(), NAME_LENGTH_CONDITION.getNumber()));
        }
    }
}
