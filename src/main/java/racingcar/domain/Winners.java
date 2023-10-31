package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public record Winners(List<Name> value) {

    public String joinWinnersNames(String delimiter) {

        return value.stream()
                .map(Name::value)
                .collect(Collectors.joining(delimiter));
    }
}
