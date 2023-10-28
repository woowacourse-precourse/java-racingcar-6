package racingcar.game.validate;

public class IntegerTrialValidator {

    private static final String NONE_INTEGER = "시도횟수를 정수로 입력하세요";

    public static Integer validate(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_INTEGER);
        }
    }
}
