package racingcar.entity;

public enum RoundScore {
    FORWARD(1), STOP(0);

    private int score;

    RoundScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
