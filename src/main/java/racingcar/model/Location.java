package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import racingcar.validator.LocationValidator;

public class Location {

    private final int location;
    private static final LocationValidator locationValidator = new LocationValidator();

    public Location(int location) {
        locationValidator.validate(location);
        this.location = location;
    }

    public static Location init() {
        return new Location(0);
    }

    public Location move() {
        if (moveCondition()) {
            return new Location(location + 1);
        }
        return new Location(location);
    }

    private boolean moveCondition() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
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
