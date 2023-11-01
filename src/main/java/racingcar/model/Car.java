package racingcar.model;

public class Car {

    private final String name;
    private String status;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.status += "-";
    }
}
