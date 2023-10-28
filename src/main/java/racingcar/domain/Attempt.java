package racingcar.domain;

import static racingcar.constant.ExceptionMessage.BLANK_EXCEPTION;
import static racingcar.constant.ExceptionMessage.DECIMAL_EXCEPTION;
import static racingcar.constant.ExceptionMessage.NON_NUMBER_EXCEPTION;
import static racingcar.constant.ExceptionMessage.NON_POSITIVE_NUMBER_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Utils;
import racingcar.view.InputView;

public class Attempt {
    private int count;

    public void startMakeAttemptNumber() {
        InputView.printRequestAttempt();
        String attemptInput = Console.readLine();
        input(attemptInput);
        InputView.printLineChanging();
    }

    public void input(String attemptInput) {
        validateAttemptNumber(attemptInput);
        this.count = Integer.parseInt(attemptInput);
    }

    public void validateAttemptNumber(String number) {
        checkNonBlank(number);
        checkInteger(number);
        checkNonDecimal(number);
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
            throw new IllegalArgumentException(NON_NUMBER_EXCEPTION);
        }
    }

    public void checkNonDecimal(String input) {
        double number = Utils.revertToDouble(input);
        if (number != (int) number) {
            throw new IllegalArgumentException(DECIMAL_EXCEPTION);
        }
    }

    public void checkPositiveNumber(String input) {
        double number = Utils.revertToDouble(input);
        if (number <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_NUMBER_EXCEPTION);
        }
    }

    public int getCount() {
        return count;
    }

}
