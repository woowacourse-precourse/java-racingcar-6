package racingcar.dto;

import racingcar.domain.Car;

public record CarInfo(String name, int position) {

    public static CarInfo of(Car car) {
        return new CarInfo(car.getName(), car.getPosition());
    }
}
