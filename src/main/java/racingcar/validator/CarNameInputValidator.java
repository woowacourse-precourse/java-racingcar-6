package racingcar.validator;


public class CarNameInputValidator implements InputValidator {

    private static final String CAR_NAME_RANGE_IN_FIVE = "자동차는 5이하의 글자수만 가능합니다.";
    private static final int CAR_NAME_BOUND = 5;

    @Override
    public void validateInput(String input) {
        keepLength(input);
    }

    public void keepLength(String input) {
        if (isValidLength(input)) {
            throw new IllegalArgumentException(CAR_NAME_RANGE_IN_FIVE);
        }
    }

    private boolean isValidLength(String input) {
        return input.length() > CAR_NAME_BOUND;
    }
}
