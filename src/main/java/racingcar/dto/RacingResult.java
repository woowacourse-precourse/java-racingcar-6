package racingcar.dto;

import racingcar.domain.Car;

public class RacingResult {

    private final String carName;
    private final int position;

    public RacingResult(final Car car) {
        this.carName = car.getCarName();
        this.position = car.getCarPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
