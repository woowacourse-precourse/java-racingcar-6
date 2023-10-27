package racingcar.dto;

import racingcar.domain.Car;

public class RacingResult {

    private final String carName;
    private final int position;

    public RacingResult(final Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
