package racingcar.model;

import static racingcar.ExceptionMessage.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAMV_VALUE_EXCEPTION;

import java.util.List;
import java.util.stream.Collectors;

public class Name {

    private static final String NAME_SPLITTER = ",";
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        validateNameLength(name);
        validateHasNotBlank(name);
        validateValidValue(name);
        this.name = name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    public static List<Name> createCarNames(final String name) {
        String[] splitNames = name.split(NAME_SPLITTER);
        List<String> names = List.of(splitNames);

        return names.stream()
                .map(Name::from)
                .collect(Collectors.toList());
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.toString());
        }
    }

    private void validateHasNotBlank(final String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.toString());
        }
    }

    private void validateValidValue(final String name) {
        if (!name.matches("^[a-zA-Z0-9가-힣]+$")) {
            throw new IllegalArgumentException(CAR_NAMV_VALUE_EXCEPTION.toString());
        }
    }

    public String getName() {
        return name;
    }
}
