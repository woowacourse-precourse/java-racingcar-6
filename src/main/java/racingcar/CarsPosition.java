package racingcar;

import java.util.Map;

public final class CarsPosition {
    private final Map<String, Integer> position;

    private CarsPosition(Map<String, Integer> position) {
        this.position = position;
    }

    public static CarsPosition createPositionWithRacingCars(RacingCars racingCars) {
        return new CarsPosition(racingCars.createInitPosition());
    }
}
