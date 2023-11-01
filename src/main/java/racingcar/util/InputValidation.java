package racingcar.util;

import static racingcar.constant.ErrorConstant.COMMA;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    // 입력값이 Null Or 빈 문자열일 경우
    public static void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이나 빈 문자열일 수 없습니다.");
        }
    }

    // 자동차 이름은 "," 로 구분되야함.
    public static void validateCommaSeparatedInput(String input) {
        String replaceAll = input.replaceAll("[가-힣a-zA-Z0-9,]", "");
        if (replaceAll.length() != 0) {
            throw new IllegalArgumentException("자동차 이름은 " + COMMA + "를 기준으로 입력하세요.");
        }
    }

    // 각 자동차의 글자 수가 5자 이하만 가능함.
    public static void validateInputLength(String input) {
        String[] words = input.split(COMMA);

        for (String word : words) {
            if (word.length() > 5) {
                throw new IllegalArgumentException("각 자동차의 글자 수는 5자 이하만 가능합니다.");
            }
        }
    }

    // 자동차 이름은 중복되어서는 안 됨.
    public static void validateDuplicateValues(String input) {
        String[] words = input.split(COMMA);

        Set<String> uniqueElements = new HashSet<>();

        for (String word : words) {
            if (!uniqueElements.add(word)) {
                throw new IllegalArgumentException("자동차 이름이 중복되면 안 됩니다.");
            }

        }
    }

    // 시도 횟수는 1이상의 10이하 자연수를 입력해야함.
    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount < 1 || attemptCount > 10) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 10 이하의 자연수여야 합니다.");
        }
    }
}
