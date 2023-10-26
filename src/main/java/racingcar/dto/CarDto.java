package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {

    private String name;
    private Integer position;

    public static CarDto of(final Car car) {
        CarDto carDto = new CarDto();
        carDto.name = car.getName();
        carDto.position = car.getPosition();

        return carDto;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
