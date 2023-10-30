package racingcar.domain.car;

public class CarDistance {
    private int distance = 0;

    protected void moveForward() {
        distance++;
    }

    protected int getDistance() {
        return distance;
    }

}
