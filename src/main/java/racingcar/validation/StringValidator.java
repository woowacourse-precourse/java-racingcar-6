package racingcar.validation;

import racingcar.util.ExceptionUtil;

public class StringValidator {

    public static void validateOverLength(String string, int maxLength) {
        if (string.length() > maxLength) {
            ExceptionUtil.throwInvalidValueException(createOverLengthMessage(maxLength));
        }
    }

    private static String createOverLengthMessage(int maxLength) {
         return String.format(
                "문자 길이가 %d보다 큽니다.", maxLength);
    }
}
