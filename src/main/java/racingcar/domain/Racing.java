package racingcar.domain;

import java.util.List;
import java.util.Objects;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;
import racingcar.exception.ErrorMessage;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new NullPointerException(ErrorMessage.EMPTY_CAR_LIST);
        }
        this.cars = cars;
    }

    public void start() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarDto> getCarWithLongestDistance() {
        int carWithLongDistance = getLongDistance();
        return cars.stream()
                .filter(car -> car.getTravelDistance() == carWithLongDistance)
                .map(CarDto::fromCar)
                .toList();
    }

    public List<CarDto> getAllCarDistances() {
        return cars.stream()
                .map(CarDto::fromCar)
                .toList();
    }

    private int getLongDistance() {
        return cars.stream()
                .map(Car::getTravelDistance)
                .reduce(Integer::max).orElse(0);
    }
}
