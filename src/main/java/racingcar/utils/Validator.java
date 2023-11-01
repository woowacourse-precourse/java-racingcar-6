package racingcar.utils;

public class Validator {
    final static int MAX_NAME_LENGTH = 5;
    final static int MIN_ATTEMPT_COUNT = 0;

    public static void carName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    public static void attemptCount(String attempt_count) {
        if (attempt_count == null || attempt_count.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }

        try {
            if (Integer.parseInt(attempt_count) <= MIN_ATTEMPT_COUNT) {
                throw new IllegalArgumentException("양수를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }


    }

}
