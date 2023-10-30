package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Long> carsIdList;
    private final int maxGameCount;
    private int currentGameCount;

    public RacingGame(List<Long> carsIdList, int maxGameCount) {
        this.carsIdList = carsIdList;
        this.maxGameCount = maxGameCount;
    }

    public List<Long> getCarsIdList() {
        return carsIdList;
    }

    public void increaseGameCount() {
        this.currentGameCount += 1;
    }

    public boolean isGameFinish() {
        return currentGameCount == maxGameCount;
    }

}
