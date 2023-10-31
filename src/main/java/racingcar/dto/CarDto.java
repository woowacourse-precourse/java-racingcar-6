package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarDto {

    private final String carName;
    private final Integer position;

    private CarDto(final String carName, final Integer position) {
        this.carName = carName;
        this.position = position;
    }

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();

        return carList.stream()
                .map(car -> new CarDto(car.getCarName().name(), car.getCarPosition().position()))
                .toList();
    }

    public String getCarName() {
        return carName;
    }

    public Integer getPosition() {
        return position;
    }
}
