package domain;

public class Car {
    private final CarName name;
    private int distance = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        distance++;
    }
}
