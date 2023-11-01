package racingcar.model.domain;

public class Car {
    private String name;
    private int forward;

    public Car(String name) {
        this.name = name;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }
}
