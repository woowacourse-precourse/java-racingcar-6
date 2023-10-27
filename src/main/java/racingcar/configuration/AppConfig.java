package racingcar.configuration;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.AttemptInput;
import racingcar.view.Input;
import racingcar.view.NamesInput;

public class AppConfig {

    public static Input getAttemptInput() {
        return new AttemptInput();
    }

    public static Input getNamesInput() {
        return new NamesInput();
    }

    public static NumberGenerator getNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
