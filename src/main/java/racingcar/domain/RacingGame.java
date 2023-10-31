package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final int START_GAME_COUNT = 0;
    private final List<Long> carsIdList;
    private final int maxGameCount;
    private int currentGameCount;

    private Long id;

    public RacingGame(List<Long> carsIdList, int maxGameCount, Long id) {
        this.carsIdList = carsIdList;
        this.maxGameCount = maxGameCount;
        this.id = id;
        this.currentGameCount = START_GAME_COUNT;
    }

    public List<Long> getCarsIdList() {
        return carsIdList;
    }

    public boolean isGameFinish() {
        return currentGameCount == maxGameCount;
    }

    public Long getId() {
        return id;
    }
}
