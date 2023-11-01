package racingcar.game.validate;

public class BlankTrialValidator {

    private static final String BLANK_TRAIL = "빈 시도 횟수를 입력했습니다.";

    public static void validate(String number) {
        if (number.isEmpty() || number.isBlank()) {
            throw new IllegalArgumentException(BLANK_TRAIL);
        }
    }
}
