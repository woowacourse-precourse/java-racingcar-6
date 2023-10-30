package racingcar.utils;

import java.util.List;
import racingcar.domain.Car;

public class InputValidator {

    public static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Message.ERROR_EMPTY_CAR_NAME_MESSAGE.getMessage());
        }
    }

    public static void validateInputLength(String input) {
        if (input.length() < 1 || input.length() > 5) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE.getMessage());
        }
    }

    public static void validateDuplicateInput(List<Car> carList, String carName) {
        for (Car car : carList) {
            if (car.getName().equals(carName)) {
                throw new IllegalArgumentException(Message.ERROR_DUPLICATE_CAR_NAME_MESSAGE.getMessage());
            }
        }
    }

    public static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NON_NUMBERIC_MOVE_COUNT_MESSAGE.getMessage());
        }
    }
}
