package racingcar;

public class Validator {

    /**
     * 콤마 사이의 공백이 있는지 확인한다.
     */
    public static void validateNoSpacesBetweenCommas(String input) {
        if (input.matches(".*,\\s.*,.*")) {
            throw new IllegalArgumentException("쉼표 간에 공백은 허용되지 않습니다.");
        }
    }

    /**
     * 사용자 입력은 한글자 이상이어야한다.
     */
    public static void validateHasAtLeastOneCharacter(String input) {
        if (input.length() == 0 || input == null || input.isEmpty()) {
            throw new IllegalArgumentException("최소 한 글자 이상 입력해야 합니다.");
        }
    }

    public static void validateOnlyNumber(String input) {
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1부터 9까지의 정수 숫자만 입력해주세요");
        }
    }

    public static void validateWithinRange(Integer input) {

        if (input < 0 || input > 2_147_483_647) {
            throw new IllegalArgumentException("입력값은 0 이상, 2,147,483,647 이하이어야 합니다.");
        }
    }
}
