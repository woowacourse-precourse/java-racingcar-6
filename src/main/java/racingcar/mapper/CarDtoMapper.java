package racingcar.mapper;

import racingcar.domain.Car;
import racingcar.dto.CarDto;

public class CarDtoMapper {
    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getMoved());
    }
}
