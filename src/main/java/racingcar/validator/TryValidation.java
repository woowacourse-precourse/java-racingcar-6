package racingcar.validator;

public class TryValidation {
    public void checkTryNumber(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요");
        }
    }

}