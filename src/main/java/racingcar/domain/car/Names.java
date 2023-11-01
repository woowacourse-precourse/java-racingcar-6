package racingcar.domain.car;

import java.util.List;

public record Names(
        List<Name> nameList
) {
    private static final String NAME_DELIMITER = ",";

    @Override
    public String toString() {
        return String.join(NAME_DELIMITER, nameList.stream().map(Name::toString).toList());
    }
}
