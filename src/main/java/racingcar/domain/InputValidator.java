package racingcar.domain;

public class InputValidator {

    public static boolean checkCarNameLength(String name) {
        if (name.length() >= 6 || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1-5글자 사이로 입력해야 합니다.");
        }

        return true;
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
