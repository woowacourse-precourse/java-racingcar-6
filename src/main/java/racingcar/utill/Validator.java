package racingcar.utill;

import static racingcar.utill.constant.ExceptionConstant.ATTEMPT_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.BLANK_INPUT_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.CAR_NAME_MAX_SIZE_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.DUPLICATE_NAME_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.NULL_INPUT_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ValidatorConstant.CAR_NAME_MAX_SIZE;
import static racingcar.utill.constant.ValidatorConstant.ZERO_AND_NATURAL_NUMBER_PATTERN;

import java.util.Arrays;
import java.util.regex.Matcher;

public final class Validator {

    public static void validateNullInput(String nullString) {
        if (nullString == null) {
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateCarsName(String carsName) {
        String[] splitCarsName = carsName.split(",", -1);
        for (String split : splitCarsName) {
            validateCarName(split);
        }
        validateDuplicatedCarName(splitCarsName);
    }

    private static void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }

        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_MAX_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDuplicatedCarName(String[] carsName) {
        Object[] noDuplicateCarsName = Arrays.stream(carsName).distinct().toArray();

        if (noDuplicateCarsName.length != carsName.length) {
            throw new IllegalArgumentException(DUPLICATE_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static void validateAttemptNumber(String attemptNumber) {
        Matcher attemptNumberMatcher = ZERO_AND_NATURAL_NUMBER_PATTERN.matcher(attemptNumber);

        if (attemptNumber.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }

        if (!attemptNumberMatcher.matches()) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
