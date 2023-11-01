package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int CRITERION_FIVE = 5;
    private static final int CRITERION_ONE = 1;

    public static void validateSeparatedByComma(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해주세요.");
        }
    }

    public static void validateCarNameLength(List<String> separatedCarNames) {
        for (String carName : separatedCarNames) {
            if (carName.length() > CRITERION_FIVE) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateDuplicateCarNames(List<String> separatedCarNames) {
        Set<String> carNames = new HashSet<>(separatedCarNames);
        if (separatedCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복되지 않은 자동차 이름을 입력해주세요.");
        }
    }

    public static void validateNonEmpty(String attemptValue) {
        if (attemptValue.isBlank()) {
            throw new IllegalArgumentException("이동 횟수를 입력해주세요.");
        }
    }

    public static void validateInputIsNumeric(String attemptValue) {
        for (char separatedAttemptValue : attemptValue.toCharArray()) {
            if (!Character.isDigit(separatedAttemptValue)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

    public static void validateAtLeastOne(int attemptCount) {
        if (attemptCount < CRITERION_ONE) {
            throw new IllegalArgumentException("이동 횟수를 1 이상 입력해주세요.");
        }
    }
}
