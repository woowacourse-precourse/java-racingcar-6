package racingcar.domain.car;

public class Distance {
    public static final int INIT_DISTANCE = 0;
    private int distance;

    public Distance() {
        this.distance = INIT_DISTANCE;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }
}
