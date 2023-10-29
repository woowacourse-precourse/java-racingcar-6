package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    private InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readRacingCarName() {
        String input = Console.readLine();
        inputValidator.validateDelimiter(input);
        return input;
    }

    public String readRepeatCount() {
        String input = Console.readLine();
        inputValidator.validateNumber(input);
        return input;
    }
}
