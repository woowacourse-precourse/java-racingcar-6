package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.message.ErrorMessage;

public class Name {

    private static final Integer MIN_NAME_LENGTH = 1;
    private static final Integer MAX_NAME_LENGTH = 5;
    private static final String WHITE_SPACE_EXISTS_REGEX = ".*\\s.*";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateNoWhiteSpace(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LENGTH_CONDITION);
        }
    }

    private void validateNoWhiteSpace(String name) {
        if (name.matches(WHITE_SPACE_EXISTS_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WHITE_SPACE_CONDITION);
        }
    }

    public static List<Name> createNameList(String names) {
        String[] splitNames = splitNames(names);
        return Arrays.stream(splitNames)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static String[] splitNames(String names) {
        return names.split(",");
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name otherName = (Name) o;
        return Objects.equals(name, otherName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}