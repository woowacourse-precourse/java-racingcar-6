package racingcar.converter;

import racingcar.domain.Car;
import racingcar.dto.CarDto;

import java.util.List;

public class CarToDtoConverter implements Converter<List<Car>, List<CarDto>> {

    @Override
    public List<CarDto> convert(List<Car> cars) {
        return cars.stream()
                .map(this::generateCarDto)
                .toList();
    }

    private CarDto generateCarDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
