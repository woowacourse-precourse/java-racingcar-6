package racingcar.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.dto.CarDto;

public class CarMapper {
    private static final String DELIMITER = ",";

    private CarMapper () {}

    public static List<Car> convertToCarList(String cars) {
        String[] tokens = cars.split(DELIMITER);
        return Arrays.stream(tokens)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public static List<CarDto> convertToCarDtoList(Cars cars) {
        return IntStream.range(0, cars.size())
                .mapToObj(index -> cars.findCarByIndex(index))
                .map(CarMapper::convertToCarDto)
                .collect(Collectors.toList());
    }

    public static CarDto convertToCarDto(Car car) {
        String name = car.getName();
        int position = car.getPosition();
        return new CarDto(name, position);
    }
}
