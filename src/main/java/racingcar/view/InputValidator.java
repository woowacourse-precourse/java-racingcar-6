package racingcar.view;

public class InputValidator {

    private static final String EMPTY_EXCEPTION = "빈값이 입력되었습니다.";

    public void validateEmpty(String input) {
        if (input.length() < 1) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
    }
}
