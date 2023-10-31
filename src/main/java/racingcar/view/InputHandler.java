package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputHandler(InputValidator inputValidator, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public Object handle() {
        String input = Console.readLine();
        inputValidator.validate(input);
        return inputParser.parse(input);
    }
}
