package racingcar;

public class Validation {
    private static final int MAX_LENGTH = 5;

    // 콤마 여부
    public static void validateNoComma(String inputNames) {
        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해주세요.");
        }
    }
    //자동차 글자 수 1 이상 5 이하
    public static void validateNameLength(String[] inputNames) {
        for (String i : inputNames) {
            if(i.length() > MAX_LENGTH || i.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하로 입력해주세요.");
            }
        }
    }
    // 자연수 여부
    public static void validateNaturalNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해주세요.");
        }
    }
}
