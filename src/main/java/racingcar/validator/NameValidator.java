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
        if (name.length() == Constants.NAME_EMPTY_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTYNAME.message());
        }
    }

    private void checkNameCorrectRange(String name) {
        if (name.length() > Constants.NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.EXPLODENAME.message());
        }
    }
}
