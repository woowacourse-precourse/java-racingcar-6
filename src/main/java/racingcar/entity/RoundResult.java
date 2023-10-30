package racingcar.entity;

public enum RoundResult {
    FORWARD(1),STOP(0);

    private int score;

    RoundResult(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
