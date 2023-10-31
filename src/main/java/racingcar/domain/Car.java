package racingcar.domain;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final ForwardDistance forwardDistance;

    public Car(final CarName name) {
        this.name = name;
        this.forwardDistance = new ForwardDistance();
    }

    public void forward() {
        forwardDistance.increase();
    }

    public CarName getName() {
        return name;
    }

    public ForwardDistance getForwardDistance() {
        return forwardDistance;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.forwardDistance.getValue(), other.forwardDistance.getValue());
    }

    @Override
    public String toString() {
        return name + " : " + forwardDistance.toString();
    }
}
