package racingcar.exception;

public class InputTryException {
    static final String NUMBER_REG = "[0-9]+";

    public void checkZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
    }

    public void checkNumber(String input) {
        if (!input.matches(NUMBER_REG)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public void checkException(String input) {
        checkZero(input);
        checkNumber(input);
    }
}
