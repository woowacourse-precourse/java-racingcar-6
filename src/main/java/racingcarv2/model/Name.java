package racingcarv2.model;

import java.util.Arrays;
import java.util.Objects;
import racingcarv2.exception.ErrorException;

public class Name {
    public static final String SEPARATOR_COMMA = ",";
    public static final int STANDARD_NAME_LENGTH = 5;
    private final String nameValue;

    public Name(final String name) {
        validateName(name.split(SEPARATOR_COMMA));
        this.nameValue = name;
    }

    private void validateName(String[] names) {
        validateLength(names);
        validateDuplication(names);
    }

    private void validateLength(String[] names) {
        Arrays.stream(names)
                .forEach(name -> isOutOfRange(name));
    }

    private void isOutOfRange(String name) {
        if (name.length() > STANDARD_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorException.OUT_OF_RANGE.getDescription());
        }
    }

    private void validateDuplication(String[] names) {
        if (!Objects.equals(Arrays.stream(names).count(), Arrays.stream(names).distinct().count())) {
            throw new IllegalArgumentException(ErrorException.DUPLICATED_NAME.getDescription());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(getNameValue(), name1.getNameValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameValue());
    }

    public String getNameValue() {
        return nameValue;
    }
}
