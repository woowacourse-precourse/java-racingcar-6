package racingcar.model;

public class Car {
    private String name;
    private int forwardCount;

    public Car(String name, int forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public Car(String name) {
        this(name, 0);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", forwardCount=" + forwardCount +
                '}';
    }
}
