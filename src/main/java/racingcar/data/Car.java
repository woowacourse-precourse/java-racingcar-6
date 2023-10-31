package racingcar.data;

public class Car {
    private final String name;
    private int moveDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void proceed() {
        moveDistance++;
    }
}
