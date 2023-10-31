package racingcar.domain;

import java.util.List;

public class Game {
    private final int playCountEnd;
    private final List<Car> cars;
    private int playCount = 0;
    public Game(List<Car> cars, int playCount) {
        this.cars = cars;
        this.playCountEnd = playCount;
    }

    public List<Car> getCars() {
        return cars;
    }



}
