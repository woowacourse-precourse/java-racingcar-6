package racingcar.Util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final String NULL_OR_EMPTY_MESSAGE = "값을 입력해주세요";
    public static final String INVALID_PATTERN_MESSAGE = "자동차의 이름은 쉼표(,)로 구분해서 입력해주세요";

    public static void validateCarNames(String inputedCarNames) {
        validateNullOrEmpty(inputedCarNames);
        validateCorrectPattern(inputedCarNames);
    }

    public static void validateNullOrEmpty(String inputedCarNames) {
        if (inputedCarNames == null || inputedCarNames.equals("")){
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }

    public static void validateCorrectPattern(String inputedCarNames) {
        Pattern pattern = Pattern.compile("^[\\w]{1,}(,[\\w]{1,})*$");
        Matcher matcher = pattern.matcher(inputedCarNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_PATTERN_MESSAGE);
        }
    }

}
