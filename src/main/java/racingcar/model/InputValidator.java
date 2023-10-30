package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_LENGTH = 5;

    public static void validateNumber(String userInputTryNumber) {
        if (!userInputTryNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void validateDuplication(List<String> carNameList) {
        if (isDuplicated(carNameList)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public static void validateEmptyName(List<String> carNameList) {
        if (isContainEmpty(carNameList)) {
            throw new IllegalArgumentException("공백인 이름이 있습니다.");
        }
    }

    public static void validateNameLength(List<String> carNameList) {
        if (isContainOverMaxLength(carNameList)) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private static boolean isDuplicated(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    private static boolean isContainEmpty(List<String> carNameList) {
        return carNameList.stream()
                .anyMatch(String::isEmpty);
    }

    private static boolean isContainOverMaxLength(List<String> carNameList) {
        return carNameList.stream()
                .anyMatch(name -> name.length() > MAX_LENGTH);
    }
}
