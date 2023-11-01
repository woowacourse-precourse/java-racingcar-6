package racingcar.dto;

import racingcar.domain.Car;

public record RacingResult(String carName, int position) {

    public RacingResult(final Car car) {
        this(car.getName(), car.getPosition());
    }
}
