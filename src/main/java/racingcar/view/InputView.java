package racingcar.view;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static racingcar.constants.MessageConstant.INVALID_INPUT_MESSAGE;
import static racingcar.utils.Console.readLine;

public class InputView {

    public String readCarNames() {
        return readLine();
    }

    public int readAttempt() {
        try {
            String attempt = readLine();
            validate(attempt);
            return parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void validate(final String attempt) {
        validateInput(attempt);
    }

    private void validateInput(final String attempt) {
        for (int index = 0; index < attempt.length(); index++) {
            char target = attempt.charAt(index);
            checkInteger(target);
        }
    }

    private void checkInteger(final char target) {
        if (!isDigit(target)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
