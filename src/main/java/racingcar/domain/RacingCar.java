package racingcar.domain;

public class RacingCar {
    private final String name;
    private Long score;

    public RacingCar(String name) {
        this.name = name;
        this.score = 0L;
    }

    public String getName() {
        return name;
    }

    public Long getScore() {
        return score;
    }

    public void move() {
        this.score += 1;
    }
}
