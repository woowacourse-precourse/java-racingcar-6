package racingcar.utils;

import org.junit.platform.commons.util.StringUtils;

public class Validator {

    public static void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
    }
}