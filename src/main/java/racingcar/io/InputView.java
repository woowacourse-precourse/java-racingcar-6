package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readCarNames() {
        final String input = Console.readLine();
        inputValidator.validateCarNames(input);
        return input;
    }
}
