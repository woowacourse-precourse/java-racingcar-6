package racingcar.model;

import java.util.List;

public class Game {
    private List<Car> cars;
    private int trialNum = 0;

    public List<Car> getCars() {
        return cars;
    }

    public void increaseTrialNum() {
        this.trialNum += 1;
    }
}
