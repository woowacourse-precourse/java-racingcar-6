package racingcar.dto;

import racingcar.domain.Car;

public record RacingResult(String name, String position) {
    public static RacingResult from(Car car) {
        return new RacingResult(car.getName(), "-".repeat(car.getMovedCount()));
    }
}
