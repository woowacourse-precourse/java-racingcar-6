package racingcar.controller.dto;

import racingcar.model.Car;

public class RacingResultResponse {

    private final String carName;
    private final int carPosition;

    private RacingResultResponse(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static RacingResultResponse from(final Car car) {
        return new RacingResultResponse(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
