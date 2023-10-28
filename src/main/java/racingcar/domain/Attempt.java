package racingcar.domain;

import static racingcar.constant.ExceptionMessage.BLANK_EXCEPTION;
import static racingcar.constant.ExceptionMessage.DECIMAL_EXCEPTION;
import static racingcar.constant.ExceptionMessage.NON_NUMBER_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
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
    }

    public void validateAttemptNumber(String number) {
        checkNonBlank(number);
        checkInteger(number);
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
        double number = Double.parseDouble(input);
        if (number != (int) number) {
            throw new IllegalArgumentException(DECIMAL_EXCEPTION);
        }
    }

    public int getCount() {
        return count;
    }

}
