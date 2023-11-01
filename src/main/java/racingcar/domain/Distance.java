package racingcar.domain;

public class Distance {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void forward() {
        distance++;
    }
}