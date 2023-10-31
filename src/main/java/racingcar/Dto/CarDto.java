package racingcar.Dto;

import racingcar.domain.Car;

public record CarDto(
        String name,
        int distance
) {
    public CarDto(Car car) {
        this(car.getName(), car.getDistance());
    }
}
