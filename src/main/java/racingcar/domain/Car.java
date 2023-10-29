package racingcar.domain;

public class Car {
    private String name;
    private int step;
    Car(String name) {
        this.name = name;
        this.step = 0;
    }
    public void moveForward() {
        step++;
    }
}
