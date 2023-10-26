package racingcar.dto;

import racingcar.domain.Car;

public record CarDto(String name, Integer position) {

    public static CarDto from(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
