package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars) {
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
