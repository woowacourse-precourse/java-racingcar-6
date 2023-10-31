package racingcar.domain;

public class RacingPlayer {
    private final String name;
    private int score;

    public RacingPlayer(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score += 1;
    }
}
