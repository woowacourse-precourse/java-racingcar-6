package racingcar.util;

public class Validator {
    public static void nameLengthLimit(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름이 5자 이상입니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("차 이름이 없거나 공백입니다.");
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
