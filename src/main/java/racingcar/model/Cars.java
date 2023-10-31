package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Cars {
    private static final int MOVING_NUM = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void raceCars() {
        cars.stream()
                .filter(this::isMoving)
                .forEach(car -> car.moveCount++);
    }
    private boolean isMoving(Car car) {
        return Randoms.pickNumberInRange(0, 9) >= MOVING_NUM;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> findWinner() {
        int maxMoveCount = getMaxMoveCount();
        return cars.stream()
                .filter(car -> car.moveCount == maxMoveCount)
                .map(car -> car.name)
                .toList();
    }
    private int getMaxMoveCount() {
        Optional<Integer> maxMoveCount = cars.stream()
                .map(car -> car.moveCount)
                .max(Integer::compare);
        if (maxMoveCount.isPresent()) {
            return maxMoveCount.get();
        }
        throw new IllegalArgumentException();
    }
}
