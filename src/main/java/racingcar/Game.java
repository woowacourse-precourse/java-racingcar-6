package racingcar;

import java.util.List;
import racingcar.exception.InsufficientCarCountException;

public class Game {
    public static final int MIN_CARS_REQUIRED = 2;
    private final List<Car> cars;
    private final int raceCount;

    public Game(List<Car> cars, int raceCount) {
        validateCars(cars);

        this.cars = cars;
        this.raceCount = raceCount;
    }

    private void validateCars(List<Car> cars) {
        if (cars.size() < MIN_CARS_REQUIRED) {
            throw new InsufficientCarCountException();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public GameResult play() {
        // TODO: 게임 플레이 구현
        return null;
    }
}
