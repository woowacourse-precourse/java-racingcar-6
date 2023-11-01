package racingcar;

import java.util.List;

public class Validation {
    private static final String COUNTS_NUMERIC_ERROR_MESSAGE = "시도 횟수는 자연수로 입력해주세요.";
    private static final String ATTEMPT_COUNTS_VALIDATE_REGEX = "^[1-9][0-9]*$";
    private static final int CAR_NAME_MIN_SIZE = 1;
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final String CAR_NAME_SIZE_ERROR_MESSAGE = "[ERROR] 이름은 1자 이상 5자 이하여야 한다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 이름은 중복될 수 없다.";
    public static void checkException(List<String> carNameList) {
        if (!checkCarNameLength(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_SIZE_ERROR_MESSAGE);
        }
        if (!checkDuplicateName(carNameList)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static boolean checkCarNameLength(List<String> carNameList) {
        return carNameList.stream()
                .filter(carName -> carName.length() >= CAR_NAME_MIN_SIZE && carName.length() <= CAR_NAME_MAX_SIZE)
                .count() == carNameList.size();
    }
    public static boolean checkDuplicateName(List<String> carNameList) {
        return carNameList.stream()
                .distinct()
                .count() == carNameList.size();
    }

    public static void checkException(String counts) {
        if (!checkNaturalNumber(counts)) {
            throw new IllegalArgumentException(COUNTS_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static boolean checkNaturalNumber(String counts) {
        return counts.matches(ATTEMPT_COUNTS_VALIDATE_REGEX);
    }
}
