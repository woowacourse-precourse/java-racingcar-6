package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Name {

    private static final String NAME_SPLITTER = ",";
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    public static List<Name> createCarNames(final String name) {
        String[] splitNames = name.split(NAME_SPLITTER);
        List<String> names = List.of(splitNames);

        return names.stream()
                .map(String::trim)
                .distinct()
                .map(Name::from)
                .collect(Collectors.toList());
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
