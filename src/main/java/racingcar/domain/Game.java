package racingcar.domain;

import java.util.List;

public class Game {

    private final int trial;
    private final List<Car> cars;
    private int trialNum = 0;

    public Game(List<Car> cars, int trial){
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars(){
        return cars;
    }

    public int increaseTrialNum() {
        this.trialNum += 1;
        return 0;
    }

    public Boolean checkReachTrialNumToTrial(){
        return this.trial == this.trialNum;

    }
}
