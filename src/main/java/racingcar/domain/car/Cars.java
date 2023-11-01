package racingcar.domain.car;

import java.util.List;
import racingcar.dto.CarStatusDto;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFrom(List<Car> cars) {
        return new Cars(cars);
    }

    public void tryDriveAll() {
        cars.forEach(Car::tryDrive);
    }

    public List<CarStatusDto> getStatusSnapShot() {
        return cars.stream()
                .map(CarStatusDto::createFrom)
                .toList();
    }


}
