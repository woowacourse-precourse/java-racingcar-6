package racingcar.domain;

import java.util.List;

public class Game {

    private final int moveCount;
    private final List<Car> cars;
    private int totalCount = 0;

    public Game(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void increaseCount() {
        this.totalCount += 1;
    }

    public boolean checkCountEnd() {
        return this.moveCount == this.totalCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
