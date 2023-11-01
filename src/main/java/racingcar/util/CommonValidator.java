package racingcar.util;

import java.util.Objects;

public class CommonValidator {
    public static void validateBlankCheck(String inputStr, String errorTarget) {
        if (Objects.isNull(inputStr) || inputStr.isEmpty()) {
            throw new IllegalArgumentException(errorTarget + "의문자열 값이 없습니다.");
        }
    }
}
