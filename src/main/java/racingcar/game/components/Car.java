package racingcar.game.components;

public class Car {
    private String name;
    private int distance;
    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public void move() {
        distance++;
    }
}
