package racingcar.domain.wrapper;

public class CarDistance {
    private static final int START_POINT = 0;
    private int distance;

    private CarDistance() {
        this.distance = START_POINT;
    }

    public static CarDistance create() {
        return new CarDistance();
    }

    public int getCarDistance() {
        return this.distance;
    }

    public void increment() {
        ++this.distance;
    }
}
