package racingcar.common.type;

public final class Distance {
    private int distance;

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance of(int distance) {
        return new Distance(distance);
    }

    public void increase() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isEqual(int targetDistance) {
        return this.distance == targetDistance;
    }
}
