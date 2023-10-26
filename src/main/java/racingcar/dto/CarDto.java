package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {

    private String name;
    private Integer position;

    public CarDto(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto of(final Car car) {
        CarDto carDto = new CarDto(car.getName(), car.getPosition());

        return carDto;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
