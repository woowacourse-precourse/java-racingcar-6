package racingcar;

public class Cars {
    private static int distance = 0;

    public static int goForward() {
        return distance++;
    }

    public int askDistance() {
        return this.distance;
    }
}
