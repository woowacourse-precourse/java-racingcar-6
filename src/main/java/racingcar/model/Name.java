package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Name {

    private static final String NAME_SPLITTER = ",";
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        validateNameLength(name);
        validateHasNotBlank(name);
        validateOnlyAlphabetAndNumber(name);
        this.name = name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    public static List<Name> createCarNames(final String name) {
        String[] splitNames = name.split(NAME_SPLITTER);
        List<String> names = List.of(splitNames);

        return names.stream()
                .distinct()
                .map(Name::from)
                .collect(Collectors.toList());
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateHasNotBlank(final String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOnlyAlphabetAndNumber(final String name) {
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
