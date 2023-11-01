package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        validateSize(cars);
        validateDuplicate(cars);
    }

    private void validateSize(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 한 개 이상 존재해야 합니다.");
        }
    }

    private void validateDuplicate(final List<Car> cars) {
        List<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (carList.contains(car)) {
                throw new IllegalArgumentException("이미 존재하는 자동차입니다.");
            }
            carList.add(car);
        }
    }

    public void moveAll(final MovingStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public CarPosition getMaxCarPosition() {
        return cars.stream()
                .map(Car::getCarPosition)
                .max(Comparator.comparingInt(CarPosition::getPosition))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> getSamePositionCarNames(final CarPosition carPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(carPosition))
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }
}
