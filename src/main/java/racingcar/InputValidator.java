package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String BLANK_EXCEPTION = "입력값이 존재하지 않습니다.";
    private static final String NOT_ONLY_NUMBER_EXCEPTION = "숫자만 입력해야 합니다.";
    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile(ONLY_NUMBER_REGEX);

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
        Matcher matcher = ONLY_NUMBER_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER_EXCEPTION);
        }
    }
}
