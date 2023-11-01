package racingcar.config;

import racingcar.service.raceservice.FixDistanceRaceService;
import racingcar.service.raceservice.RaceService;

public class AppConfig {
    public static final int DISTANCE_MIN = 0;
    public static final int DISTANCE_MAX = 9;
    public static final int MOVE_CRITERIA = 4;
    public static final int POSITION_MAX = Integer.MAX_VALUE;

    public static RaceService raceServiceImplements() {
        return new FixDistanceRaceService();
    }
}
