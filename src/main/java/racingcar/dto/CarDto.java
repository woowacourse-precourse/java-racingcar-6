package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.vo.CarName;
import racingcar.vo.CarPosition;

public record CarDto(CarName carName, CarPosition carPosition) {

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();

        return carList.stream()
                .map(car -> new CarDto(car.getCarName(), car.getCarPosition()))
                .toList();
    }
}
