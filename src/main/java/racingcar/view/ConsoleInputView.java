package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.console_input.BlankInputException;

public class ConsoleInputView implements InputView {

    @Override
    public String readLine() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(final String input) {
        if (input.isBlank()) {
            throw new BlankInputException();
        }
    }
}
