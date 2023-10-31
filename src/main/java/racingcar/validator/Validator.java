package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateSeparatedByComma(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해주세요.");
        }
    }

    public static void validateCarNameLength(List<String> separatedCarNames) {
        for (String carName : separatedCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateHasDuplicateCarNames(List<String> separatedCarNames) {
        Set<String> carNames = new HashSet<>(separatedCarNames);
        if (separatedCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복되지 않은 자동차 이름을 입력해주세요.");
        }
    }

    public static void validateIsNumeric(String attempt) {
        for (char separatedAttempt : attempt.toCharArray()) {
            if (!Character.isDigit(separatedAttempt)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

    public static void validateNonEmpty(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("이동 횟수를 입력해주세요.");
        }
    }

    public static void validateAtLeastOne(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException("이동 횟수를 1 이상 입력해주세요.");
        }
    }
}
