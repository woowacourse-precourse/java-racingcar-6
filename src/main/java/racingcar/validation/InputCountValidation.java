package racingcar.validation;

/**
 * 입력되는 회수의 유효성 검사
 */
public class InputCountValidation {

    public static String inputCountValidation(String input) {
        if (isNumberFormat(input)) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isNumberFormat(String input) {
        return input.matches("[0-9]+");
    }
}
