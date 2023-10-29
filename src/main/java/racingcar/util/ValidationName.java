package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationName {

    private ValidationName() {}

    public static void validateCarNames(String carNames) {
        validateLength(carNames);
        validateDuplication(carNames);
    }

    public static void validateLength(String carNames) {
        Arrays.stream(carNames.split(","))
                .map(carName -> carName.trim())
                .forEach(carName -> checkLength(carName));
    }

    public static void validateDuplication(String carNames) {
        int beforeSize = carNames.split(",").length;
        List<String> nameList = makeUnduplicateNameList(carNames);
        int afterSize = nameList.size();
        if (beforeSize != afterSize) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATION.getExceptionMessage());
        }
    }

    private static void checkLength(String carName) {
        int length = carName.length();
        if (length < NameLengthCondition.MIN_LENGTH.getLength()
                || length > NameLengthCondition.MAX_LENGTH.getLength()) {
            throw new IllegalArgumentException(ExceptionMessages.LENGTH.getExceptionMessage());
        }
    }

    private static List<String> makeUnduplicateNameList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(carName -> carName.trim())
                .distinct()
                .collect(Collectors.toList());
    }
}
