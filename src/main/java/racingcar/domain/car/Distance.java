package racingcar.domain.car;

public class Distance {
    protected int distance = 0;

    protected Distance() {

    }

    public void add(int number) {
        this.distance += number;
    }

    protected boolean isEqualOrGreaterThan(Car otherCar) {
        return distance >= otherCar.distance.distance;
    }

    protected boolean isCarWithMaxDistance(Car carWithMaxDistance) {
        return distance == carWithMaxDistance.distance.distance;
    }

    public String toString() {
        return "-".repeat(distance);
    }
}