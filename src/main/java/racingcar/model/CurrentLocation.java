package racingcar.model;

import static racingcar.model.SystemValueConstants.defaultLocation;

public class CurrentLocation {
    private int current;

    private CurrentLocation(int current) {
        this.current = current;
    }

    public static CurrentLocation createCurrentLocation() {
        return new CurrentLocation(defaultLocation());
    }

    public int getCurrent() {
        return current;
    }

    public void moveLocation() {
        current++;
    }
}
