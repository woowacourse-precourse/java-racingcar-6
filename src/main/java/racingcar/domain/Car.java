package racingcar.domain;

public class Car {

    public String name;
    public int forward;

    public Car(String name) {
        this.name = name;
        this.forward = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }
}
