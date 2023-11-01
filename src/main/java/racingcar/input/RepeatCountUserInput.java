package racingcar.input;

import racingcar.utils.StringValidateUtils;

public class RepeatCountUserInput implements UserInput<Integer> {

    private final ConsoleUserInput consoleUserInput;

    public RepeatCountUserInput(ConsoleUserInput consoleUserInput) {
        this.consoleUserInput = consoleUserInput;
    }

    @Override
    public Integer input() {
        final String userInput = consoleUserInput.input();
        validate(userInput);
        return Integer.parseInt(userInput);
    }

    private void validate(final String userInput) {
        StringValidateUtils.validateEmptyString(userInput);
        validateNumber(userInput);
    }

    private void validateNumber(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
