package racingcar;

import racingcar.service.raceservice.FixDistanceRaceService;
import racingcar.service.raceservice.RaceService;

public class AppConfig {
    public static final int NAME_LENGTH_MIN = 1;
    public static final int NAME_LENGTH_MAX = 5;
    public static final String NAME_FORMAT = String.format("[a-zA-Z]{%d,%d}",NAME_LENGTH_MIN, NAME_LENGTH_MAX);
    public static final String INPUT_DELIMITER = ",";
    public static final int PARTICIPANT_MIN = 2;
    public static final int DISTANCE_MIN = 0;
    public static final int DISTANCE_MAX = 9;
    public static final int MOVE_CRITERIA = 4;

    public static RaceService raceServiceImplements() {
        return new FixDistanceRaceService();
    }
}
