package racingcar.domain;

public class Score {
    private final String name;
    private Long score;

    public Score(String name, Long score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Long getScore() {
        return score;
    }

    public void addScore(Long score) {
        this.score += score;
    }
}
