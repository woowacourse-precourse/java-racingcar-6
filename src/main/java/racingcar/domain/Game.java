package racingcar.domain;

import java.util.List;

public class Game {

    private List<Car> cars;
    private int currentAttemptCnt = 0;
    private int finalAttemptCnt;

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
}
