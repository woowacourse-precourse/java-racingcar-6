package racingcar.model;

import java.util.List;

public class Game {
    private int trial;
    private List<Car> cars;
    private int triedNum = 0;

    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTriedNum() {
        return triedNum;
    }

    public void increaseTriedNum() {
        this.triedNum += 1;
    }
}
