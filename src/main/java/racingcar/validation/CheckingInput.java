package racingcar.validation;

import static racingcar.constants.ExceptionMessage.EXCEPTION_ATTEMT_DIGIT;
import static racingcar.constants.ExceptionMessage.EXCEPTION_ATTEMT_RANGE;
import static racingcar.constants.ExceptionMessage.EXCEPTION_CARS_COUNT;
import static racingcar.constants.ExceptionMessage.EXCEPTION_NAME_DUPLICATE;
import static racingcar.constants.ExceptionMessage.EXCEPTION_NAME_LENGTH;

import java.util.Arrays;

public class CheckingInput {
    static void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException(EXCEPTION_NAME_LENGTH);
        }
    }

    static void validateCarNamesLength(int carNamesLength) {
        if (carNamesLength < 2) {
            throw new IllegalArgumentException(EXCEPTION_CARS_COUNT);
        }
    }

    static void validateNamesDuplicate(String[] carNames) {
        boolean duplicated = Arrays.stream(carNames)
                .distinct()
                .count() != carNames.length;

        if (duplicated) {
            throw new IllegalArgumentException(EXCEPTION_NAME_DUPLICATE);
        }
    }

    static void validateLetter(char letter) {
        if (letter < '0' || letter > '9') {
            throw new IllegalArgumentException(EXCEPTION_ATTEMT_DIGIT);
        }
    }

    static void validateCountValue(int countNum) {
        if (countNum <= 0) {
            throw new IllegalArgumentException(EXCEPTION_ATTEMT_RANGE);
        }
    }

    public static void checkInputNames(String[] carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
        }

        validateCarNamesLength(carNames.length);
        validateNamesDuplicate(carNames);
    }

    public static void checkInputCount(String count) {
        for (int i = 0; i < count.length(); i++) {
            char letter = count.charAt(i);
            validateLetter(letter);
        }

        int countNum = Integer.parseInt(count);
        validateCountValue(countNum);
    }
}
