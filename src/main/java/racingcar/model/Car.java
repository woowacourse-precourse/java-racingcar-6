package racingcar.model;

public class Car {
    private String name;
    private int status;

    public Car(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public void move() {
        status++;
    }
}