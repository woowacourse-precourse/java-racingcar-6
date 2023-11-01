package racingcar.domain;

public class Car {
    private final Name name;
    private final Distance distance;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void forward() {
        distance.forward();
    }
}
