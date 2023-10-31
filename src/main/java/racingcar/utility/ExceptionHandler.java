package racingcar.utility;

import racingcar.constant.Error;

public class ExceptionHandler {

    private static ExceptionHandler exceptionHandler = new ExceptionHandler();

    private ExceptionHandler() {
    }

    public static ExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public void isBlank(String inputValue) {
        if (inputValue.equals("") ||
                inputValue.equals("\n") ||
                inputValue.equals(null)) {
            throw new IllegalArgumentException(Error.BLANK_INPUT);
        }
    }

    public void isExceedLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(Error.EXCEED_NAME);
        }
    }

}
