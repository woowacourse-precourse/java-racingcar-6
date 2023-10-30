package racingcar.manager;

import static racingcar.validate.InputValidator.validateName;

import java.util.Arrays;
import racingcar.view.Input;
import racingcar.view.Output;

public class IOManager {

    private final Input input;
    private final Output output;

    public IOManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public Names getNames() {
        String[] inputNames = input.getNames().split(",");
        validateName(inputNames);

        return new Names(Arrays.stream(inputNames).toList());
    }
}
