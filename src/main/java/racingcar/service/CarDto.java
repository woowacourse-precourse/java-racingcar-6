package racingcar.service;

import racingcar.model.Car;

public class CarDto {
    private final String carName;
    private final int position;

    public CarDto(final String carName, final int position) {
        this.carName = carName;
        this.position = position;
    }

    public static final CarDto from(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public final String getName() {
        return this.carName;
    }

    public final int getPosition() {
        return this.position;
    }
}
