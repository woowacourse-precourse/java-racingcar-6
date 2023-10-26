package racingcar;

public class Cars {
    private static int distance = 0;

    public int goForward() {
        return distance++;
    }

    public int askDistance() {
        return this.distance;
    }
}
