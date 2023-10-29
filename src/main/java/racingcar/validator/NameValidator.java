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
        if (isEmpty(name)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTYNAME.message());
        }
    }

    private boolean isEmpty(String name) {
        return name.length() < NameConstants.LOW_BOUND.getValue();
    }

    private void checkNameCorrectRange(String name) {
        if (isRangeOver(name)) {
            throw new IllegalArgumentException(ExceptionMessage.EXPLODENAME.message());
        }
    }

    private boolean isRangeOver(String name) {
        return name.length() > NameConstants.HIGH_BOUND.getValue();
    }
}
