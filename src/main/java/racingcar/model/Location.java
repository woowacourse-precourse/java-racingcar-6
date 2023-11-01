package racingcar.model;

public class Location {

    private static final String EMPTY_SPACE = "";
    private static final String FORWARD_MOVEMENT_INDICATOR = "-";

    private String location = EMPTY_SPACE;

    public void goForward() {
        location += FORWARD_MOVEMENT_INDICATOR;
    }

    public int getLocationLength() {
        return location.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Location location1 = (Location) o;

        return location.equals(location1.location);
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public String toString() {
        return location;
    }
}
