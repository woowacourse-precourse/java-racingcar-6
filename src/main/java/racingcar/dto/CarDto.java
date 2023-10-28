package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public record CarDto(String name, Integer step) {

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();
        return carList.stream()
                .map(car -> new CarDto(car.getName(), car.getStep()))
                .toList();
    }
}