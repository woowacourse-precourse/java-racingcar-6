package racingcar.model;

public class Car {

    private final String name;
    private int status = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        status++;
    }
}
