package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.output.Output;

public class Input {
    private final Output output;

    public Input(Output output) {
        this.output = output;
    }

    public String read(String message) {
        output.message(message);
        return Console.readLine();
    }

}
