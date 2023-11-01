package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGroupValidator {
    private static final Integer MIN_CAR_COUNT = 2;
    private static final String CAR_COUNT_ERROR = "최소 2개 이상의 자동차를 입력해야 합니다.";
    private static final String DUPLICATE_CAR_ERROR = "중복된 자동차 이름이 존재합니다.";

    public static void validate(List<String> names) {
        validateCarCount(names);
        validateDuplicate(names);
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }
    }

    private static void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_ERROR);
        }
    }
}
