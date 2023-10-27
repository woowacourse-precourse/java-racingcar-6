package racingcar.domain;

public class Car {
    private String name;
    private int forward;

    public void setName(String name) {
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
