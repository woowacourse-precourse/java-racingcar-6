package racingcar.util;

import racingcar.model.Name;
import java.util.List;
import java.util.stream.Stream;

public class NameFactory {

    private static final String NAME_SPLITTER = ",";

    public static List<Name> createNames(final String names) {
        String[] splitNames = names.split(NAME_SPLITTER);

        return Stream.of(splitNames)
                .map(Name::from)
                .toList();
    }
}
