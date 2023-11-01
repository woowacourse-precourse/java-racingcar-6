package racingcar;

public class Validator {

    /**
     * 콤마 사이의 공백이 있는지 확인한다.
     */
    public static void validateNoSpacesBetweenCommas(String input) {
        String[] splited = input.split(",");

        for (String s : splited) {
            if (s.matches("^\\s+.*|.*\\s+$")) {
                throw new IllegalArgumentException("쉼표 간에 공백은 허용되지 않습니다.");
            }
        }
    }

    /**
     * 이름은 한 글자 이상, 다섯글자 이하여야한다.
     */
    public static void validateNameLength(String input) {
        if (input.length() < 0 ||  input.length() > 5) {
            throw new IllegalArgumentException("이름은 한 글자 이상 다섯 글자 이하여야합니다.");
        }
    }

    /**
     * 사용자 입력은 비어있지 않아야한다.
     */
    public static void validateNotNullAndEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public static void validateOnlyNumber(String input) {
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1부터 9까지의 정수 숫자만 입력해주세요");
        }
    }

    public static void validateWithinIntegerRange(Integer input) {

        if (input < 0 || input > 2_147_483_646) {
            throw new IllegalArgumentException("입력값은 1 이상, 2,147,483,646 미만이어야 합니다.");
        }
    }
}
