package racingcar;

public class Car {
    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }
}
