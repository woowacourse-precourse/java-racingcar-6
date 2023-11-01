package racingcar;
public class Car {
    private String name;
    private int forward;

    public Car(String name) {
        this.name = name;
        this.forward = 0;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public String getName() {
        return name;
    }
}

