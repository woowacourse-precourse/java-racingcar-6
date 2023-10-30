package racingcar.service;

import racingcar.exception.ExceptionMessage;

public class TextProcessor {
    private StringBuilder builder;

    public int parseTryNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INTEGER_FORMAT
                    .getErrorMessage());
        }
    }

}
