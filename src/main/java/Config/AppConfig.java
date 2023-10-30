package Config;

import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerIntegerRanged;

public class AppConfig {
    public static final String INPUT_NAME_DELIMITER = ",";
    public static final int PARTICIPANT_MIN = 2;
    public static final int PARTICIPANT_MAX = Integer.MAX_VALUE;
    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_FORMAT_REGEX =
            String.format("[a-zA-Z]{%d,%d}", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    public static final int CAR_POSITION_MAX = Integer.MAX_VALUE;
    public static RaceController raceControllerImplements() {
        return new RaceControllerIntegerRanged();
    }
}
