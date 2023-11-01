package racingcar.domain.car;

import static racingcar.global.enums.Constant.MAX_NAME_LENGTH;
import static racingcar.global.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.NAME_HAS_WHITE_SPACE_MESSAGE;


public class Name {

    private final String name;

    public Name(String name) {
        validateHasBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH.getConstant()) {
            throw new IllegalArgumentException(EXCEED_MAX_LENGTH_MESSAGE.getMessage());
        }
    }

    private void validateHasBlank(final String name) {
        if (hasBlank(name)) {
            throw new IllegalArgumentException(NAME_HAS_WHITE_SPACE_MESSAGE.getMessage());
        }
    }

    private boolean hasBlank(final String name) {
        return name.chars().anyMatch(Character::isWhitespace);
    }

    public int length() {
        return name.length();
    }

    public String getName() {
        return name;
    }

}
