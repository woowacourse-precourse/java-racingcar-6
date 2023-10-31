package racingcar.model;

import java.util.List;
import java.util.Objects;

public record Entries(List<String> entries) {

    private static final String NO_DUPLICATE_NAME_MSG = "중복된 이름은 불가능합니다.";
    private static final String NO_BLANK_NAME_MSG = "비어있는 이름은 불가능합니다.";
    private static final String BLANK = "";

    public Entries {
        validate(entries);
    }

    private void validate(List<String> entries) {
        if (entries.stream().distinct().count() != entries.size()) {
            throw new IllegalArgumentException(NO_DUPLICATE_NAME_MSG);
        }

        if (entries.stream().anyMatch(entry -> Objects.equals(entry.trim(), BLANK))) {
            throw new IllegalArgumentException(NO_BLANK_NAME_MSG);
        }
    }
}
