package racingcar.model;

import java.util.List;

public class Game {
    private int trial;
    private List<Car> cars;
    private int trialNum = 0;

//    public Game(List<Car> cars, int trialNum) {
//        this.cars = cars;
//        this.trialNum = trialNum;
//    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseTrialNum() {
        this.trialNum += 1;
    }

    public void setTrial(int trialNum) {
        this.trial = trialNum;
    }
}
