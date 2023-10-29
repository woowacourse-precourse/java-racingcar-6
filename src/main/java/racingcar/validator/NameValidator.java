package racingcar.validator;

import racingcar.Constants;
import racingcar.ExceptionMessage;

public enum NameValidator {
    INSTANCE;

    public void validateName(String name) {
        checkNameIsEmpty(name);
        checkNameCorrectRange(name);
    }

    private void checkNameIsEmpty(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTYNAME.message());
        }
    }

    private boolean isEmpty(String name) {
        return name.length() == Constants.NAME_EMPTY_SIZE;
    }

    private void checkNameCorrectRange(String name) {
        if (isRangeOver(name)) {
            throw new IllegalArgumentException(ExceptionMessage.EXPLODENAME.message());
        }
    }

    private boolean isRangeOver(String name) {
        return name.length() > Constants.NAME_MAX_LENGTH;
    }
}
