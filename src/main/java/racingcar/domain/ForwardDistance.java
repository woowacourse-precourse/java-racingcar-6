package racingcar.domain;

public class ForwardDistance {

    private int distance;

    public ForwardDistance() {
        this.distance = 0;
    }

    public void increase() {
        distance++;
    }

    public int getValue() {
        return distance;
    }

    @Override
    public String toString() {
        return "-".repeat(distance);
    }
}
