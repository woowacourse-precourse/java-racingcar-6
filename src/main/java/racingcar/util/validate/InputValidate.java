package racingcar.util.validate;

public class InputValidate {

    static public int validateInputNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    static public void validateInputNumberRange(int number) {
        if(number > 9 || number < 0) {
            throw new IllegalArgumentException("0부터 9사이의 숫자를 입력해주세요.");
        }
    }
}
