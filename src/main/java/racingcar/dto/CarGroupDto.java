package racingcar.dto;

import java.util.List;

public class CarGroupDto {
    private final List<CarDto> cars;

    public CarGroupDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
