package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

public record CarDto(CarName carName, CarDistance carDistance) {

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();
        return carList.stream()
                .map(car -> new CarDto(car.getCarName(), car.getCarDistance()))
                .toList();
    }
}
