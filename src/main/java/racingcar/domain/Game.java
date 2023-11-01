package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars;
    private int currentAttemptCnt = 0;
    private int finalAttemptCnt = 0;


    public Game() {
    }

    public Game(List<Car> cars, int finalAttemptCnt) {
        this.cars = cars;
        this.finalAttemptCnt = finalAttemptCnt;
    }

    public void increaseCurrentAttemptCnt() {
        this.currentAttemptCnt++;
    }

    public boolean checkAttemptCountFinal() {
        return this.currentAttemptCnt == this.finalAttemptCnt;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCurrentAttemptCnt() {
        return currentAttemptCnt;
    }

    public int getFinalAttemptCnt() {
        return finalAttemptCnt;
    }
}
