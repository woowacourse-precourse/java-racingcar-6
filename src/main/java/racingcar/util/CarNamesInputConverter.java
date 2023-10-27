package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesInputConverter {
    private static final String DELIMITER = ",";
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "유효하지 않은 입력값 오류. %s. %s";
    private static final String INVALID_LENGTH_MESSAGE = "이름 길이는 %d 이상 %d 이하만 가능"
            .formatted(NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private static final String DUPLICATED_MESSAGE = "중복된 이름은 존재할 수 없음";

    public static List<String> convert(String input) {
        List<String> names = List.of(input.split(DELIMITER));
        validateLength(names);
        validateUnique(names);
        return names;
    }

    private static void validateLength(List<String> names) {
        boolean anyInvalidLength = names.stream()
                .anyMatch(v -> v.length() < NAME_MIN_LENGTH || v.length() > NAME_MAX_LENGTH);
        if (anyInvalidLength) {
            throw new IllegalArgumentException(
                    ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(INVALID_LENGTH_MESSAGE, names));
        }
    }

    private static void validateUnique(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(DUPLICATED_MESSAGE, names));
        }
    }
}
