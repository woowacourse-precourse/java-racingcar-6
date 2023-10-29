package domain;

public class Car {
    private final CarName name;
    private int score = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getScore() {
        return score;
    }

    public void move() {
        score++;
    }
}
