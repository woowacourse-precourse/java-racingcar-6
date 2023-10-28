package racingcar;

public class InputValidator {
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String BLANK_EXCEPTION = "입력값이 존재하지 않습니다.";
    private static final String NOT_ONLY_NUMBER_EXCEPTION = "숫자만 입력해야 합니다.";

    public void validCarNameLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    public void validTrialNumber(String input){
        validNotEmpty(input);
        validOnlyNumber(input);
    }

    private void validNotEmpty(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(BLANK_EXCEPTION);
        }
    }

    private void validOnlyNumber(String input) {
        if (!input.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER_EXCEPTION);
        }
    }
}
