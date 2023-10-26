package racingcar;

public class Cars {
    private int distance = 0;
    private final String carName;

    public Cars(String carName) {
        this.carName = carName;
    }

    public int goForward() {
        return ++distance;
    }

    public String getName() {
        return this.carName;
    }

    public int askDistance() {
        return this.distance;
    }
}
