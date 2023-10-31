package racingcar.dto;

import racingcar.domain.car.Car;

public record CarDto(String name, int travelDistance) {

    public static CarDto fromCar(Car car) {
        return new CarDto(car.getName(), car.getTravelDistance());
    }
}
