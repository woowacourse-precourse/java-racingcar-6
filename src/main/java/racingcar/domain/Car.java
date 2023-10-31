package racingcar.domain;

public class Car {
    private final String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void go(){
        this.score += 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
