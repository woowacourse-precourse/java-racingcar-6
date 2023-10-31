package racingcar.utill;

import static racingcar.utill.constant.ExceptionConstant.ATTEMPT_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.BLANK_INPUT_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.CAR_NAME_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.DUPLICATE_NAME_EXCEPTION;
import static racingcar.utill.constant.ExceptionConstant.NULL_INPUT_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ValidatorConstant.CAR_NAME_MAX_SIZE;
import static racingcar.utill.constant.ValidatorConstant.NATURAL_NUMBER_PATTERN;

import java.util.List;
import java.util.regex.Matcher;
import racingcar.domain.Car;

public final class Validator {

    public static void validateNullInput(String nullString) {
        if (nullString == null) {
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }

        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static void validateAttemptNumber(String attemptNumber) {
        Matcher attemptNumberMatcher = NATURAL_NUMBER_PATTERN.matcher(attemptNumber);

        if (attemptNumber.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }

        if (!attemptNumberMatcher.matches()) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateDuplicatedCarName(List<Car> carList) {
        List<Car> noDuplicateList = carList.stream().distinct().toList();

        if (carList.size() != noDuplicateList.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_EXCEPTION);
        }
    }
}
