package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public record Names(List<Name> value) {

    public String joinNamesWithDelimiter(String delimiter) {

        return value.stream()
                .map(Name::value)
                .collect(Collectors.joining(delimiter));
    }
}
