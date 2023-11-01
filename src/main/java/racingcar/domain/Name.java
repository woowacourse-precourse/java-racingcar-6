package racingcar.domain;

import static racingcar.exception.ErrorMessage.CAR_NAME_NOT_BLANK;
import static racingcar.exception.ErrorMessage.CAR_NAME_OVER_MAX_LENGTH;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final char BLANK = ' ';
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        validateBlankName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_OVER_MAX_LENGTH);
        }
    }

    private void validateBlankName(String name) {
        boolean anyCharMatchGap = name.chars()
                .anyMatch(ch -> ch == BLANK);

        if (anyCharMatchGap) {
            throw new IllegalArgumentException(CAR_NAME_NOT_BLANK);
        }
    }
}