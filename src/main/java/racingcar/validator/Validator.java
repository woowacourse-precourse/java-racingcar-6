package racingcar.validator;

import java.util.List;

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

    public static void validateIsNumeric(String attempt) {
        for (char separatedAttempt : attempt.toCharArray()) {
            if (!Character.isDigit(separatedAttempt)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }
}
