package racingcar.utils;

import static racingcar.utils.Constants.MAX_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_NUMBER_OF_CARS;
import static racingcar.utils.Constants.MIN_NUMBER_OF_ROUNDS;
import static racingcar.utils.ErrorMessages.NOT_DISTINCT_NAMES_MESSAGE;
import static racingcar.utils.ErrorMessages.NOT_NATURAL_NUMBER_MESSAGE;
import static racingcar.utils.ErrorMessages.NOT_POSITIVE_INTEGER_MESSAGE;
import static racingcar.utils.ErrorMessages.WRONG_NAME_LENGTH_MESSAGE;
import static racingcar.utils.ErrorMessages.WRONG_NUMBER_OF_CARS_MESSAGE;

import java.util.List;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNumberOfCars(int sizeOfCarList) {
        if (sizeOfCarList < MIN_NUMBER_OF_CARS) {
            raiseIllegalArgumentException(WRONG_NUMBER_OF_CARS_MESSAGE);
        }
    }

    public static void validateIsNamesDistinct(List<String> carNames) {
        boolean isNotDistinctNames = (carNames.stream().distinct().count() != carNames.size());

        if (isNotDistinctNames) {
            raiseIllegalArgumentException(NOT_DISTINCT_NAMES_MESSAGE);
        }
    }

    public static void validateNameLength(int nameLength) {
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            raiseIllegalArgumentException(WRONG_NAME_LENGTH_MESSAGE);
        }
    }

    public static void validateIsInputNumber(String userInput) {
        boolean isNotNumber = !userInput.chars().allMatch(Character::isDigit);

        if (isNotNumber) {
            raiseIllegalArgumentException(NOT_POSITIVE_INTEGER_MESSAGE);
        }
    }

    public static void validateIsNaturalNumber(int integer) {
        if (integer < MIN_NUMBER_OF_ROUNDS) {
            raiseIllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
        }
    }

    private static void raiseIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
