package racingcar.dto;

import racingcar.model.Car;

public class CarDto {
    private String carName;
    private int movedDistance;

    public CarDto(Car car) {
        this.carName = car.getCarName();
        this.movedDistance = car.getMovedDistance();
    }

    public CarDto(String carName, int movedDistance) {
        this.carName = carName;
        this.movedDistance = movedDistance;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
