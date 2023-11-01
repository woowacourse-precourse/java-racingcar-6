package racingcar.domain.car;

import racingcar.constants.ErrorConsts;

public record Name(
        String name
) {
    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validate(name);
        name = name.trim();
    }

    @Override
    public String toString() {
        return name;
    }

    private void validate(final String name) {
        validateNullity(name);
        validateBlank(name);
        validateLength(name);
    }

    private void validateNullity(final String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorConsts.NULL_CAR_NAME.getMessage());
        }
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorConsts.BLANK_CAR_NAME.getMessage());
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorConsts.LONG_CAR_NAME.getFormattedMessage(MAX_NAME_LENGTH));
        }
    }
}
