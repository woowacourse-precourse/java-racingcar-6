package racingcar.domain;

import java.util.Objects;

public class Location {
    private final int location;

    public Location() {
        this(0);
    }

    public Location(int location) {
        this.location = location;
    }

    public boolean isMax(Location maxLocation) {
        return this.location >= maxLocation.location;
    }

    public int getLocation() {
        return location;
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
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
