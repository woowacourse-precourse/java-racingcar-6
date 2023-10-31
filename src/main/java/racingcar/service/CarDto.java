package racingcar.service;

import racingcar.model.Car;

public class CarDto {
    private String carName;
    private int position;

    public CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
