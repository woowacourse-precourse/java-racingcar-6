package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
    private final String name;
    private final int position;

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.nameValue(), car.positionValue());
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }
}
