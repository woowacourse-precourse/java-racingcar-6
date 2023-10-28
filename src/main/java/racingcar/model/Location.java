package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import racingcar.validator.LocationValidator;

public class Location {

    private final int value;
    private static final LocationValidator locationValidator = new LocationValidator();

    public Location(int value) {
        locationValidator.validate(value);
        this.value = value;
    }

    public static Location init() {
        return new Location(0);
    }

    public Location move() {
        if (moveCondition()) {
            return new Location(value + 1);
        }
        return new Location(value);
    }

    private boolean moveCondition() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
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
