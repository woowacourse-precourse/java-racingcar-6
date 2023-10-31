package racingcar;

import static racingcar.BoundaryValue.MAX_NAME_LENGTH;
import static racingcar.BoundaryValue.MIN_CAR_COUNT;
import static racingcar.BoundaryValue.MIN_ROUND;
import static racingcar.Error.BLANK_ERROR;
import static racingcar.Error.CAR_COUNT_ERROR;
import static racingcar.Error.DUPLICATION_ERROR;
import static racingcar.Error.LENGTH_ERROR;
import static racingcar.Error.NOT_NUMBER_ERROR;
import static racingcar.Error.ROUND_COUNT_ERROR;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void checkCount(List<String> carNames) {

        if (carNames.size() < MIN_CAR_COUNT.get()) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR.getMessage());
        }

    }

    public static void checkBlank(List<String> carNames) {

        for (String carName : carNames) {

            if (carName.isBlank()) {
                throw new IllegalArgumentException(BLANK_ERROR.getMessage());
            }

        }

    }

    public static void checkLength(List<String> carNames) {

        for (String carName : carNames) {

            if (carName.length() > MAX_NAME_LENGTH.get()) {
                throw new IllegalArgumentException( LENGTH_ERROR.getMessage());
            }

        }

    }

    public static void checkDuplication(List<String> carNames) {

        CarManager.trimNames(carNames);

        if (carNames.size() > new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }

    }

    public static void checkNumber(String userInput) {

        try {

            if (Integer.parseInt(userInput) < MIN_ROUND.get()) {
                throw new IllegalArgumentException(ROUND_COUNT_ERROR.getMessage());
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }

    }
}
