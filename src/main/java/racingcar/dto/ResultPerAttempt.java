package racingcar.dto;

import racingcar.model.car.Car;

public class ResultPerAttempt {

    private static final String COLON = " : ";
    private final String carName;
    private final int position;

    public ResultPerAttempt(Car car) {
        this.carName = car.getCarName();
        this.position = car.getPosition();
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return this.getCarName() + COLON;
    }

    public int getPosition() {
        return position;
    }
}
