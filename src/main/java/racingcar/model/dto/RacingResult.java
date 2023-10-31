package racingcar.model.dto;

import racingcar.model.Car;

public class RacingResult {

    private final String carName;
    private final int carPosition;

    private RacingResult(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static RacingResult from(final Car car) {
        return new RacingResult(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
