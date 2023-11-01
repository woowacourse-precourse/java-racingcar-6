package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesInputConverter {
    private static final String NAME_DELIMITER = ",";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "유효하지 않은 입력값 입니다. %s. 입력값: %s";
    private static final String INVALID_LENGTH_MESSAGE = "자동차 이름 길이는 %d 이상 %d 이하만 가능합니다"
            .formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private static final String DUPLICATED_MESSAGE = "중복된 이름은 존재할 수 없습니다";

    private CarNamesInputConverter() {
    }

    public static List<String> convert(String input) {
        List<String> names = List.of(input.split(NAME_DELIMITER));
        validateNameLength(names);
        validateNameUniqueness(names);
        return names;
    }

    private static void validateNameLength(List<String> names) {
        boolean hasInvalidLength = names.stream().anyMatch(name -> !isValidNameLength(name));
        if (hasInvalidLength) {
            throw new IllegalArgumentException(
                    ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(INVALID_LENGTH_MESSAGE, names));
        }
    }

    private static boolean isValidNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    private static void validateNameUniqueness(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(DUPLICATED_MESSAGE, names));
        }
    }
}
