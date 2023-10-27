package racingcar.model;

import java.util.Objects;
import racingcar.validator.LocationValidator;

public class Location {

    private final int value;
    private static final LocationValidator locationValidator = new LocationValidator();

    public Location(int value) {
        locationValidator.validate(value);
        this.value = value;
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
        return value == location1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
