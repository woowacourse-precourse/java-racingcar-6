package racingcar.domain.car;

public class Distance {
    private int distance = 0;

    public void add(int number) {
        this.distance += number;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return "-".repeat(distance);
    }
}