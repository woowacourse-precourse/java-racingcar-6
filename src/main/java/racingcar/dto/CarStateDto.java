package racingcar.dto;

import racingcar.domain.Car;

public class CarStateDto {
    private final Car carStatus;

    public CarStateDto(Car carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarStatus() {
        return carStatus.toString();
    }

    public String getCarName() {
        return carStatus.getName();
    }

    public int getCarPosition() {
        return carStatus.getPosition();
    }
}