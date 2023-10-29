package racingcar.utils.validation;

public class Validator {
    // 빈 입력값 검사
    protected static void isEmpty(String string, String message) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // 공백 검사
    protected static void hasSpace(String string, String message) {
        if (string.contains(" ")) {
            throw new IllegalArgumentException(message);
        }
    }

}
