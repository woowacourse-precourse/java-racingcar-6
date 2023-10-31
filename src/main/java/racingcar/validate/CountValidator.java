package racingcar.validate;

public class CountValidator {
    public static final String INPUT_INTEGER_MESSAGE = "정수를 입력하셔야 합니다.";
    public static final String POSITIVE_INPUT_INTEGER_MESSAGE = "양의 정수를 입력하세요.";

    public static Integer numberValidate(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_INTEGER_MESSAGE);
        }
        if (Integer.signum(count) != 1) {
            throw new IllegalArgumentException(POSITIVE_INPUT_INTEGER_MESSAGE);
        }
        return count;
    }
}
