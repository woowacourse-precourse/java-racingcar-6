package racingcar.model;

public class Score {
    private String carName;
    private int moveCount;

    public Score(final String carName, final int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
