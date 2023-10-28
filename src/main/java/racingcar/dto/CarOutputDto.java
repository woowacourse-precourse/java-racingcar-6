package racingcar.dto;

import racingcar.domain.Car;

public class CarOutputDto {
    private String name;
    private Integer position;

    public CarOutputDto(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public CarOutputDto(Car car) {
        this.name = car.name();
        this.position = car.position();
    }
}
