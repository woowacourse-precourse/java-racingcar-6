package racingcar.domain.car;

public class Distance {
    private int distance = 0;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void add(int number) {
        this.distance += number;
    }

    protected int getDistance() {
        return distance;
    }
}
