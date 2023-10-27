package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readRacingCarNames() {
        final String input = Console.readLine();
        inputValidator.validateRacingCarNames(input);
        return input;
    }

    public String readTryCount() {
        final String input = Console.readLine();
        inputValidator.validateTryCount(input);
        return input;
    }
}
