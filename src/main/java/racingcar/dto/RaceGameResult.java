package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record RaceGameResult(boolean isCompleted, List<TrackPerResult> trackPerResults) {

    public static RaceGameResult createAlreadyCompletedResult() {
        return new RaceGameResult(true, List.of());
    }

    public static RaceGameResult processGameResult(List<TrackPerResult> trackPerResults) {
        return new RaceGameResult(false, trackPerResults);
    }

    public boolean isNotCompleted() {
        return !isCompleted;
    }

    public record TrackPerResult(String name, int distance) {
        private static final String DISTANCE_UNIT = "-";

        public static TrackPerResult from(Car car) {
            return new TrackPerResult(car.getName(), car.getLap());
        }

        public String toResult() {
            return String.format("%s : %s", name, DISTANCE_UNIT.repeat(distance));
        }
    }
}
