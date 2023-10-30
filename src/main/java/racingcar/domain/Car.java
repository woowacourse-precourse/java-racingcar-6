package racingcar.domain;

public class Car {
    private final Name name;
    private int distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }

    public void forward() {
        this.distance++;
    }
}
