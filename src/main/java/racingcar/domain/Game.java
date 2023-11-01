package racingcar.domain;

import java.util.List;

public class Game {

    private static final int DEFAULT_TOTAL_ATTEMPTS = 0;

    private final int totalAttempts;
    private final List<RacingCar> racingCarList;
    private int attempts;

    public Game(List<RacingCar> racingCarList, int totalAttempts) {
        this.racingCarList = racingCarList;
        this.totalAttempts = totalAttempts;
        this.attempts = DEFAULT_TOTAL_ATTEMPTS;
    }

    public void increaseAttempts() {
        this.attempts += 1;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public boolean isGameEnd() {
        return attempts == totalAttempts;
    }

}
