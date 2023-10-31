package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(RandomMoveStrategy randomMoveStrategy) {
        for (Car car : cars) {
            if (randomMoveStrategy.isMovable()) {
                car.move();
            }
        }
    }

    public List<CarDto> getStatus() {
        return CarDto.from(cars);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}