package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

public class InputCarNameValidator {
    private static final String NON_INPUT_ERROR_MESSAGE = "입력하지 않으셨습니다. 자동차 이름을 입력해주세요";
    private static final String OVER_FIVE_ERROR_MESSAGE = "자동차 이름은 최대 5글자 입니다.";
    private static final String NON_COMMA_ERROR_MESSAGE = "이름은 쉼표(,)로 구분해 주세요";
    private static final String INPUT_PATTERN_ERROR_MESSAGE = "이름 형식에 맞게 입력해주세요";
    private static final String[] inputMark = {".", "/", "-","&"};
    private static final String inputPattern = "^[가-힣\\w,]*$";

    public void validateNonInputCarName(String carName) {
        if (carName.equals("")) {
            throw new IllegalArgumentException(NON_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateOverFiveCarName(String carName) {
        List<String> eachCarName = List.of(carName.split(","));

        for (String str : eachCarName) {
            if (str.length() > 5) {
                throw new IllegalArgumentException(OVER_FIVE_ERROR_MESSAGE);
            }
        }
    }

    public void validateNonCommaCarName(String carName) {
        for (String mark : inputMark) {
            if (carName.contains(mark)) {
                throw new IllegalArgumentException(NON_COMMA_ERROR_MESSAGE);
            }
        }
    }

    public void validateWrongType(String carName) {
        if (!Pattern.matches(inputPattern, carName)) {
            throw new IllegalArgumentException(INPUT_PATTERN_ERROR_MESSAGE);
        }
    }
}
