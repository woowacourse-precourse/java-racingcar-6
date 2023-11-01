package racingcar.domain.data;

import racingcar.constants.Message;
import java.util.Objects;

public class CarName {

    private final String name;

    private CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    public static CarName from(final String name) {
        return new CarName(name);
    }

    private void validateName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException(Message.INVALID_CAR_NAME);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(Message.INVALID_CAR_NAME);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.OVER_LENGTH_CAR_NAME);
        }
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarName otherCarName = (CarName) obj;
        return Objects.equals(name, otherCarName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
