package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    private void validate(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 한 개 이상 존재해야 합니다.");
        }
    }

    public void moveAll(final MovingStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .mapToInt(p -> p)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
