package racingcar.validator;

import racingcar.constants.ExceptionMessage;
import racingcar.constants.NameConstants;

public enum NameValidator {
    INSTANCE;

    public void validateName(String name) {
        checkNameIsEmpty(name);
        checkNameCorrectRange(name);
    }

    private void checkNameIsEmpty(String name) {
        if (isEmpty(name.length())) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_NAME.message());
        }
    }

    private boolean isEmpty(int nameLength) {
        return nameLength < NameConstants.LOW_BOUND.getValue();
    }

    private void checkNameCorrectRange(String name) {
        if (isRangeOver(name.length())) {
            throw new IllegalArgumentException(ExceptionMessage.EXPLODE_NAME.message());
        }
    }

    private boolean isRangeOver(int nameLength) {
        return nameLength > NameConstants.HIGH_BOUND.getValue();
    }
}
