package racingcar.domain;

public class Car {
    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
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
