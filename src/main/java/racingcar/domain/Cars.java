package racingcar.domain;

import java.util.List;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.dto.CarDto;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = mapToCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> mapToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .toList();
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<CarDto> dtos() {
        return cars.stream()
                .map(CarDto::from)
                .toList();
    }
}
