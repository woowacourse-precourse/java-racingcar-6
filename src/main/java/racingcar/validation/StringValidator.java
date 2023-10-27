package racingcar.validation;

import racingcar.message.ErrorMessage;

public class StringValidator {

    public static void stringNullAndBlankCheck(String text) {
        stringIsNull(text);
        stringIsBlank(text);
    }

    public static void stringIsNull(String text) {
        if (text == null) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_BLANK_MESSAGE.getValue());
        }
    }

    public static void stringIsBlank(String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_BLANK_MESSAGE.getValue());
        }
    }
}