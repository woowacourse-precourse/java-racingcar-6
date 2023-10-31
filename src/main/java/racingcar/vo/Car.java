package racingcar.vo;

public final class Car {
    private final String name;
    private final Integer score;

    public Car(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public String getScoreBoard() {
        String repeatScore = "-".repeat(score);
        return name + " : " + repeatScore;
    }

    public Car makeNewCar() {
        return new Car(this.name, this.score + 1);
    }

    public String isScoreBiggerThanMaxScore(Integer maxScore) {
        if (maxScore < score) {
            return "Bigger";
        } else if (maxScore.equals(score)) {
            return "Equal";
        }
        return "Less";
    }
}
