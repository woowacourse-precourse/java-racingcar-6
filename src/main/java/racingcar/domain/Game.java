package racingcar.domain;

public class Game {

    private static final int DEFAULT_TOTAL_ATTEMPTS = 0;

    private final int totalAttempts;
    private final RacingCarList racingCarList;
    private int attempts;

    public Game(RacingCarList racingCarList, int totalAttempts) {
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

    public RacingCarList getRacingCarList() {
        return racingCarList;
    }

    public boolean isGameEnd() {
        return attempts == totalAttempts;
    }

}
