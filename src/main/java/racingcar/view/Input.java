package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final InputValidator inputValidator = new InputValidator();

    public String readCarNames() {
        return read();
    }

    public String readCount() {
        return read();
    }

    private String read() {
        String input = Console.readLine();
        inputValidator.validateEmpty(input);
        return input;
    }
}
