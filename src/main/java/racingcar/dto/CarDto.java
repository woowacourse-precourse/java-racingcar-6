package racingcar.dto;

import racingcar.domain.Car;

public record CarDto(String name, int position) {

    public static CarDto of(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
