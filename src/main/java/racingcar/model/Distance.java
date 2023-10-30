package racingcar.model;

public class Distance {
    private static final long INITIAL_DISTANCE = 0;

    private long distance;

    public Distance() {
        distance = INITIAL_DISTANCE;
    }

    public void move() {
        distance++;
    }

    public int compare(Distance distance) {
        return Long.compare(this.distance, distance.distance);
    }

    public long getDistance() {
        return distance;
    }
}