package racingcar.model;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        forwardCount++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", forwardCount=" + forwardCount +
                '}';
    }
}
