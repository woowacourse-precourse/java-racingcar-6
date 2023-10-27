package Config;

import racingcar.Controller.RaceController;
import racingcar.Controller.RaceControllerIntegerVer;

public class AppConfig {
    public static final String INPUT_DELIMITER = ",";
    public static final String CAR_NAME_FORMAT = "[a-zA-Z]{1,5}";
    public static RaceController raceControllerImplements() {
        return new RaceControllerIntegerVer();
    }

}
