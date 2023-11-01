package racingcar.utility;

import racingcar.constant.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (name.length() > 5) {
            throw new IllegalArgumentException(Error.EXCEED_NAME);
        }
    }

    public void isNumeric(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (inputValue.charAt(i) > '9' || inputValue.charAt(i) < '0') {
                throw new IllegalArgumentException(Error.NUMERIC_INPUT);
            }
        }
    }

    public void isNaturalNumber(int inputValue) {
        if (inputValue == 0) {
            throw new IllegalArgumentException(Error.IS_NOT_NATURAL_NUMBER);
        }
    }

    public void isDuplicationName(List<String> carNames) {
        Set<String> nonoverlappingList = new HashSet<>(carNames);

        if(nonoverlappingList.size() != carNames.size()) {
            throw new IllegalArgumentException(Error.DUPLICATED_NAME);
        }
    }

}
