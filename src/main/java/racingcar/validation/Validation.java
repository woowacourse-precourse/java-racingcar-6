package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int MINIMUM_NUMBER_OF_NAMES = 2;
    private static final int MINIMUM_LENGTH_OF_NAME = 5;
    private static final int MINIMUM_NUMBER_OF_ATTEMPTS = 1;
    public static void validateEmptyInput(String strInput) {
        if (strInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈칸입니다.");
        }
    }

    public static void validateLength(List<String> nameList) {
        if (nameList.size() < MINIMUM_NUMBER_OF_NAMES) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 두 개 이상 적어주세요.");
        }
    }

    public static void validateNameLength(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > MINIMUM_LENGTH_OF_NAME) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateUnique(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    public static void validateInteger(String numStr) {
        if (!numStr.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static void validateRange(int numInt) {
        if (numInt < MINIMUM_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 수를 입력해 주세요.");
        }
    }
}
