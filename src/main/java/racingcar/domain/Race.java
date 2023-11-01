package racingcar.domain;

import java.util.List;

public class Race {
    private int moveTime;
    private List<Car> cars;

    public Race(List<Car> cars, int moveTime) {
        this.moveTime = moveTime;
        this.cars = cars;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public List<Car> getCars() {
        return cars;
    }
}
