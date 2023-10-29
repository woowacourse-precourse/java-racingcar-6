package racingcar.utils;

import racingcar.domain.Car;
import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class CarToDtoConverter implements Converter<List<Car>, List<CarDto>> {

    @Override
    public List<CarDto> convert(List<Car> cars) {
        return cars.stream()
                .map(this::generateCarDto)
                .collect(Collectors.toList());
    }

    private CarDto generateCarDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
