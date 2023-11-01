package racingcar.utils;

import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final String INVALID_INPUT_BLANK = "잘못된 입력값입니다.(빈칸 혹은 공백)";
    private static final String INVALID_INPUT_NOT_INTEGER = "정수만 입력해 주세요.";
    private static final String DUPLICATE_NAME = "자동차의 이름은 중복될 수 없습니다.";

    public static void validateIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT_BLANK);
        }
    }

    public static void validateDuplicateCarName(List<String> carNames) {
        HashSet<String> carNameSet = new HashSet<>(carNames);

        if (isDuplicateNameExist(carNames, carNameSet)) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    private static boolean isDuplicateNameExist(List<String> carNames, HashSet<String> carNameSet) {
        return carNameSet.size() != carNames.size();
    }

    public static void validateIsInteger(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_INTEGER);
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Validator() {
    }
}