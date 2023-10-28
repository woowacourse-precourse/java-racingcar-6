package racingcar.domain.validator;

public class RoundNumberValidator implements InputValidator<String> {

    private static final String INVALID_ROUND_NUMBER_ERROR = "시도할 회수는 0이상의 정수여야 합니다.";
    @Override
    public void validate(String target) {
        checkType(target);
    }

    private void checkType(String target) {
        if (!canConvertToInteger(target)) {
            throw new IllegalArgumentException(INVALID_ROUND_NUMBER_ERROR);
        }
    }

    private static boolean canConvertToInteger(String target) {
        try {
            Integer.parseInt(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
