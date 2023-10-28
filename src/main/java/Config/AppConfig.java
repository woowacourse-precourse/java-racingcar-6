package Config;

import racingcar.Controller.RaceController;
import racingcar.Controller.RaceControllerIntegerVer;

public class AppConfig {
    public static final String INPUT_NAME_DELIMITER = ",";
    public static final int INPUT_NAME_QUANTITY_LIMIT = Integer.MAX_VALUE;
    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_FORMAT = String.format("[a-zA-Z]{%d,%d}", NAME_MIN_LENGTH, NAME_MAX_LENGTH);

    public static RaceController raceControllerImplements() {
        return new RaceControllerIntegerVer();
    }

}
