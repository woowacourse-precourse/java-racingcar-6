package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String WHITESPACES_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    private final String value;

    Input(String value) {
        this.value = value;
    }

    public static Input readLine() {
        return new Input(Console.readLine());
    }

    public String trimmed() {
        return value.replaceAll(WHITESPACES_REGEX, BLANK_STRING);
    }
}
