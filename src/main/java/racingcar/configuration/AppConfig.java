package racingcar.configuration;

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
}
