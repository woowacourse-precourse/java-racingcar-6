package racingcar.domain;

import java.util.List;

public class Game {
    private final int playCount;
    private final List<Car> cars;

    public Game(List<Car> cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    public List<Car> getCars() {
        return cars;
    }



}
