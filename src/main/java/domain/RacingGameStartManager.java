package domain;

import java.util.Set;

public class RacingGameStartManager {
    private static final int RACING_CAR_MAX_LENGTH = 5;
    private static final int RACING_CAR_MIN_LENGTH = 1;

    private boolean isRacingCarNameLengthInRange(String racingCarName) {
        return (racingCarName.length() >= RACING_CAR_MIN_LENGTH) && (racingCarName.length() <= RACING_CAR_MAX_LENGTH);
    }

    private boolean isRacingCarNameUnique(String racingCarName, Set<RacingCar> racingCarSet) {
        return racingCarSet.stream()
                .map(RacingCar::getName)
                .noneMatch(name -> name.equals(racingCarName));
    }
}
