package racingcar.config;

import racingcar.Game;
import racingcar.input.ConsoleInput;
import racingcar.input.Input;
import racingcar.output.ConsoleOutput;
import racingcar.output.Output;
import racingcar.validator.Validator;

public class Configuration {

    public static Game game() {
        return new Game(input(), output());
    }

    public static Input input() {
        return new ConsoleInput(validator());
    }

    public static Output output() {
        return new ConsoleOutput();
    }

    public static Validator validator() {
        return new Validator();
    }
}
