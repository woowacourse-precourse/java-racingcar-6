package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public record CarDto(String carName, Integer position) {

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();

        return carList.stream()
                .map(car -> new CarDto(car.getCarName().name(), car.getCarPosition().position()))
                .toList();
    }
}
