package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String value;

    Input(String value) {
        this.value = value;
    }

    public static Input readLine() {
        return new Input(Console.readLine());
    }
}
