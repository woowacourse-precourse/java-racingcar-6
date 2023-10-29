package config;

import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerIntegerRanged;

public class RaceConfig {
    public static final int MOVABLE_CRITERIA = 4;
    public static final int MOVE_START_RANGE = 0;
    public static final int MOVE_END_RANGE = 9;
    public static RaceController raceControllerImplements() {
        return new RaceControllerIntegerRanged();
    }

}
