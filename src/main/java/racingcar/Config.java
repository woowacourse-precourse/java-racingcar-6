package racingcar;

import racingcar.IO.ConsoleInputOutputHelper;
import racingcar.IO.InputOutputHelper;

public class Config {
    public static final int FORWARD_STEP = 1;
    public static final int TRUE_THRESHOLD_NUMBER = 4;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int CAR_START_LOCATION = 0;

    public static InputOutputHelper getSystemIOHelper() {
        return new ConsoleInputOutputHelper();
    }
}