package racingcar.model;

public class RacingCar {

    String name;
    int score;

    private RacingCar(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static RacingCar nameOf(String name) {
        return new RacingCar(name, 0);
    }

    public void addScore() {
        this.score++;
    }

    public String getCarInfo() {
        return this.name + " : " + this.getScoreBars();
    }

    private String getScoreBars() {
        return "-".repeat(this.score);
    }
}
