package racingcar.domain;

public class Location {

    private static final int INITIAL_POSITION_SIZE = 0;
    private int location;

    private Location() {
        this.location = INITIAL_POSITION_SIZE;
    }

    public static Location initial() {
        return new Location();
    }

    public void move() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }
}
