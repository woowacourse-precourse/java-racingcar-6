package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private final List<Car> allCars;
    private final MoveStrategy moveStrategy;

    public Cars(final List<String> names, final MoveStrategy moveStrategy) {
        allCars = names.stream()
                .map(Car::new)
                .toList();
        this.moveStrategy = moveStrategy;
    }

    public void moveAllCars() {
        allCars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(allCars);
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return allCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return allCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("자동차가 없습니다."));
    }
}
