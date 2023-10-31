package racingcar.domain.car;

public class Distance {
    private int distance = 0;

    protected Distance() {

    }

    public void add(int number) {
        this.distance += number;
    }

    public boolean isEqualOrGreaterThan(Car otherCar) {
        return distance >= otherCar.distance.distance;
    }

    public boolean isCarWithMaxDistance(Car carWithMaxDistance) {
        return distance == carWithMaxDistance.distance.distance;
    }

    public String toString() {
        return "-".repeat(distance);
    }
}