package racingcar.util.style;

import racingcar.exception.ExceptionMessages;
import racingcar.exception.RacingCarException;

public class DistanceStyleFactory {
    public static DistanceStyle create(final DistanceStyles distanceStyles) {
        validateDistanceStyles(distanceStyles);
        return switch (distanceStyles) {
            case DASH -> new DashDistanceStyle();
            default -> throw RacingCarException.of(ExceptionMessages.DISTANCE_NOT_FOUND);
        };
    }

    private static void validateDistanceStyles(final DistanceStyles distanceStyles) {
        if (distanceStyles == null) {
            throw RacingCarException.of(ExceptionMessages.DISTANCE_NOT_FOUND);
        }
    }
}
