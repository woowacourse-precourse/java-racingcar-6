package racingcar;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int raceCount;

    public Game(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public GameResult play() {
        // TODO: 게임 플레이 구현
        return null;
    }
}
