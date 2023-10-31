package racingcar.model;

public class CurrentLocation {
    private int current;

    private static final int DEFAULT_LOCATION = 0;

    private CurrentLocation(int current) {
        this.current = current;
    }

    public static CurrentLocation createCurrentLocation() {
        return new CurrentLocation(DEFAULT_LOCATION);
    }

    public int getCurrent() {
        return current;
    }

    public void moveLocation() {
        current++;
    }
}
