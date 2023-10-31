package domain;

import java.util.List;

public class Game {
    private final int input_trial;
    private final List<Car> carList;
    private int cuurent_trial = 0;

    public Game(List<Car> carList, int input_trial) {
        this.carList = carList;
        this.input_trial = input_trial;
    }

    public void increaseCurrentTrial() {
        this.cuurent_trial += 1;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Boolean checkTrial() {
        return this.input_trial == this.cuurent_trial;
    }
}
