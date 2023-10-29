package racingcar.game.domain;

public class Round {

    private final int movingCount;

    private Round(int movingCount) {
        this.movingCount = movingCount;
    }

    public static Round create(String StringMovingCount) {
        int movingCount = Integer.parseInt(StringMovingCount);
        return new Round(movingCount);
    }

    public int getMovingCount() {
        return movingCount;
    }
}
