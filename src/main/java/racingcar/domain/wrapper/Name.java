package racingcar.domain.wrapper;

import java.util.Objects;

import static racingcar.domain.constant.CarConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.util.message.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.util.message.ExceptionMessage.LENGTH_MESSAGE;

public class Name {
    private final String name;

    private Name(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name.trim();
    }

    public static Name create(final String carName) {
        return new Name(carName);
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "이름"));
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(String.format(LENGTH_MESSAGE.getValue(), CAR_NAME_MAX_LENGTH.getValue()));
        }
    }

    @Override
    public boolean equals(Object diffCarName) {
        if (this == diffCarName) return true;
        if (diffCarName == null || getClass() != diffCarName.getClass()) return false;
        Name carName = (Name) diffCarName;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
