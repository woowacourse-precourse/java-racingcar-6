package racingcar.configuration;

import racingcar.view.Input;
import racingcar.view.NamesInput;

public class AppConfig {

    public static Input getNumberInput() {
        return new NamesInput();
    }

    public static Input getNamesInput() {
        return new NamesInput();
    }
}
