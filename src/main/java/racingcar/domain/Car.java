package racingcar.domain;

public class Car {

    private String name;
    private int forwardDistance;

    private Car() {
    }

    public Car(String name) {
        this.name = name;
        this.forwardDistance = 0;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        this.forwardDistance++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForwardDistance() {
        return forwardDistance;
    }

    public void setForwardDistance(int forwardDistance) {
        this.forwardDistance = forwardDistance;
    }
}
