package racingcar.domain;

import java.util.List;

public class Game {

    private int trial;
    private List<Car> cars;
    private int currentTrial;

    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
        this.currentTrial = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseTrial() {
        currentTrial++;
    }

    public boolean isEnd() {
        return (trial == currentTrial);
    }
}
