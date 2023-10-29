package racingcar.domain;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void updateScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public StringBuilder createRoundRaceResult() {
        StringBuilder raceResult = new StringBuilder(this.name + " : ");
        raceResult.append("-".repeat(Math.max(0, this.score)));
        return raceResult;
    }
}