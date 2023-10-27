package racingcar.utils;

import racingcar.constants.ExceptionMessages;

public class InputValidator {
    private static final String SPACING_STRING = " ";
    private static final String EMPTY_STRING = "";

    public String preprocessInputString(String inputString) {
        if (isNull(inputString)) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        if (isEmpty(inputString)) {
            ExceptionMessages.EMPTY_INPUT.throwException();
        }
        return removeSpacing(inputString);
    }

    private String removeSpacing(String inputString) {
        return inputString.replaceAll(SPACING_STRING, EMPTY_STRING);
    }

    private boolean isNull(String inputString) {
        return inputString == null;
    }

    private boolean isEmpty(String inputString) {
        return inputString == EMPTY_STRING;
    }
}
