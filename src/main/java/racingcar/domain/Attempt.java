package racingcar.domain;

import static racingcar.constant.ExceptionMessage.BLANK_EXCEPTION;
import static racingcar.constant.ExceptionMessage.NON_INTEGER_EXCEPTION;
import static racingcar.constant.ExceptionMessage.NON_POSITIVE_NUMBER_EXCEPTION;

import racingcar.Utils;
import racingcar.view.InputView;

public class Attempt {
    private int attemptNumber;

    public void saveAttemptNumber() {
        String attemptInput = InputView.printRequestAttempt();
        validateAttemptNumber(attemptInput);
        this.attemptNumber = Integer.parseInt(attemptInput);
    }

    public void validateAttemptNumber(String number) {
        checkNonBlank(number);
        checkInteger(number);
        checkPositiveNumber(number);
    }

    public void checkNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION);
        }
    }

    public void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_EXCEPTION);
        }
    }

    public void checkPositiveNumber(String input) {
        double number = Utils.revertToDouble(input);
        if (number <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_NUMBER_EXCEPTION);
        }
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

}
