package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.message.ErrorMessage.CAR_NAME_OVER_SIZE_ERROR;
import static racingcar.message.ErrorMessage.CAR_NAME_NULL_ERROR;

public class Car {

    public static final int CAR_NAME_LENGTH = 5;
    private static final String POSITION = "-";
    private static final String CAR_MESSAGE_DELIMITER = " : ";

    private final String name;
    private int position = 0;

    public Car(String name) {
        String refined = name.trim();
        validateName(refined);
        this.name = refined;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_OVER_SIZE_ERROR.getMessage());
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(CAR_NAME_NULL_ERROR.getMessage());
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String toMessage() {
        String movement = POSITION.repeat(position);
        return String.join(CAR_MESSAGE_DELIMITER, name, movement);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car other = (Car) obj;
            return name.equals(other.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
