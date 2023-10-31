package racingcar.domain;

public class Game {
    private final int carsCount;
    private final int roundCount;

    public Game(int carsCount, int roundCount) {
        this.carsCount = carsCount;
        this.roundCount = roundCount;
    }

    public int getCarsCount() {
        return carsCount;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
