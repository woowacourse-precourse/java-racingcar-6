package racingcar.domain.util;

import java.util.Arrays;

public class ValidationName {

    public static void validateLength(String carNames) {
        Arrays.stream(carNames.split(","))
                .map(carName -> carName.trim())
                .forEach(carName -> checkLength(carName));
    }

    private static void checkLength(String carName) {
        int length = carName.length();
        if (length < NameLengthCondition.MIN_LENGTH.getLength()
                || length > NameLengthCondition.MAX_LENGTH.getLength()) {
            throw new IllegalArgumentException(ExceptionMessages.LENGTH.getExceptionMessage());
        }
    }
}
