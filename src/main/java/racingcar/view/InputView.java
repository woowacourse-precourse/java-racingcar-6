package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String readRacingCarName() {
        final String input = Console.readLine();
        inputValidator.validateDelimiter(input);
        return input;
    }

    public String readRepeatCount() {
        final String input = Console.readLine();
        inputValidator.validateNumber(input);
        return input;
    }
}
