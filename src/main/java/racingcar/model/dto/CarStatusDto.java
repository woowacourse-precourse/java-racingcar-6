package racingcar.model.dto;

import racingcar.model.Car;

public class CarStatusDto {
    private final String name;
    private final int tryCount;

    public CarStatusDto(Car car) {
        this.name = car.getName();
        this.tryCount = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getTryCount() {
        return tryCount;
    }
}
