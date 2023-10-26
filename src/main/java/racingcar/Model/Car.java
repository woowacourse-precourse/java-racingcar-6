package racingcar.Model;

public class Car {
    private final String name;
    private int moves = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.moves++;
    }

}