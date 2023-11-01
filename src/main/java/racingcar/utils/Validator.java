package racingcar.utils;

public class Validator {
    final static int MAX_NAME_LENGTH = 5;
    final static int MIN_ATTEMPT_COUNT = 0;

    public static void carName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("공백은 이름으로 사용할 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    public static void playCount(String play_count) {
        if (play_count == null || play_count.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (Integer.parseInt(play_count) < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("양수를 입력하세요.");
        }
    }

}
