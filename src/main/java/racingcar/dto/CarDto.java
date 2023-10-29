package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.vo.CarName;

public record CarDto(CarName carName, Integer step) {

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();
        return carList.stream()
                .map(car -> new CarDto(car.getCarName(), car.getCarDistance().distance()))
                .toList();
    }
}