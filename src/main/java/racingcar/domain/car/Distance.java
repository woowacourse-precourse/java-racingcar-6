package racingcar.domain.car;

public class Distance {
    private int distance = 0;

    protected Distance() {

    }

    public void add(int number) {
        this.distance += number;
    }

    protected int getDistance() {
        return distance;
    }

    public String toString() {
        return "-".repeat(distance);
    }
}