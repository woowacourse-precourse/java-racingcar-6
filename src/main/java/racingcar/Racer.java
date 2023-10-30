package racingcar;

public class Racer {
    private String name;

    private StringBuilder score;

    public Racer(String name) {
        this.name = name;
        this.score = new StringBuilder();
    }

    public void move() {
        score.append('-');
    }

    public String getName() {
        return name;
    }

    public StringBuilder getScore() {
        return score;
    }
}

