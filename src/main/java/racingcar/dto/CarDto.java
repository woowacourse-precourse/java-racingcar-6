package racingcar.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarDto {

    private final String name;
    private final Integer step;

    public CarDto(final String name, final Integer step) {
        this.name = name;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public Integer getStep() {
        return step;
    }

    public static List<CarDto> toDtoList(final Cars cars) {
        List<Car> carList = cars.getCarList();
        return carList.stream()
                .map(car -> new CarDto(car.getName(), car.getStep()))
                .toList();
    }
}