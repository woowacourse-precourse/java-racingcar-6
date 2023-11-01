package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.dto.CarDto;

public class Cars {
    private final List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        validateDuplicated(carNames);
        List<Car> cars = mapToCars(carNames);
        return new Cars(cars);
    }

    private static void validateDuplicated(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    private static List<Car> mapToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .toList();
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<CarDto> maxPositionCarDtos() {
        CarPosition maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.positionEquals(maxPosition))
                .map(CarDto::from)
                .toList();
    }

    private CarPosition findMaxPosition() {
        CarPosition maxPosition = CarPosition.zero();
        for (Car car : cars) {
            maxPosition = car.biggerPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<CarDto> dtos() {
        return cars.stream()
                .map(CarDto::from)
                .toList();
    }
}
