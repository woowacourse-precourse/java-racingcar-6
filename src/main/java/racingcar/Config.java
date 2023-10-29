package racingcar;

import racingcar.IO.ConsoleInputOutputHelper;
import racingcar.IO.InputOutputHelper;

public class Config {

    public static InputOutputHelper getSystemIOHelper() {
        return new ConsoleInputOutputHelper();
    }
}
