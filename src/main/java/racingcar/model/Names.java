package racingcar.model;

import racingcar.model.exception.ExceptionMessage;
import java.util.List;
import java.util.stream.Stream;

public class Names {

    private static final String SPLITTER = ",";

    private final List<Name> names;

    private Names(final List<Name> names) {
        this.names = names;
    }

    public static Names from(final String input) {
        String[] splitNames = input.split(SPLITTER);
        List<Name> names = Stream.of(splitNames)
                .map(Name::from)
                .toList();

        validateNamesIsNotDuplicate(names);
        return new Names(names);
    }

    private static void validateNamesIsNotDuplicate(final List<Name> names) {
        List<Name> uniqueNames = names.stream()
                .distinct()
                .toList();

        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_CAR_EXCEPTION.getMessage());
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
