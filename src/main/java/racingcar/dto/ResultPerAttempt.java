package racingcar.dto;

import racingcar.model.car.Car;

public class ResultPerAttempt {
    private final String carName;
    private final int position;

    public ResultPerAttempt(Car car) {
        this.carName = car.getCarName();
        this.position = car.getPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
