package model;

public class Car {

    private final Name name;
    private final MovingCount movingCount;

    public Car(String name) {
        this.name = new Name(name);
        this.movingCount = new MovingCount();
    }
}
