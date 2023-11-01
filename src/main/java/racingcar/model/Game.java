package racingcar.model;

import java.util.List;

public class Game {
    private int trial;
    private List<Car> cars;
    private int NumberOfTry = 0;

    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTriedNum() {
        return NumberOfTry;
    }

    public void increaseTriedNum() {
        this.NumberOfTry += 1;
    }
}
