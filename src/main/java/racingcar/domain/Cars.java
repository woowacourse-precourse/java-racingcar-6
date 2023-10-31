package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    void moveAll(MoveStrategy moveStrategy) {
        cars.stream()
                .filter(car -> moveStrategy.isAbleToMove())
                .forEach(Car::move);
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();

        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return Collections.unmodifiableList(winners);
    }

    private int getMaxPosition() {
        int maxPosition = -1;

        for (Car car : this.cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }
}
