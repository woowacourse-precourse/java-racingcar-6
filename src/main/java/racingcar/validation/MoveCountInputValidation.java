package racingcar.validation;

public class MoveCountInputValidation {

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("움직일 횟수의 입력값이 숫자가 아닙니다.");
        }
    }
}
