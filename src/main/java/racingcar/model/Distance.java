package racingcar.model;

public class Distance {
    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance addDistance() {
        return new Distance(distance + 1);
    }

    public int getDistance() {
        return distance;
    }
}
