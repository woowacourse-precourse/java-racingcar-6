package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;

/*
 *   플레이어의 정보를 담당
 * */

public class GamePlayer {

    private final List<Car> cars;

    private GamePlayer(List<Car> cars) {
        this.cars = cars;
    }

    public static GamePlayer from(List<Car> cars) {
        return new GamePlayer(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxMoveDistance() {
        return cars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
