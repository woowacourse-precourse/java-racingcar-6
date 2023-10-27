package racingcar.util.validator;

import racingcar.util.messages.ErrorMessages.CarNameInputErrorMessages;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public void checkCarNameInputValidation(List<String> list) {
        checkIsCarNameListEmpty(list);
        checkCarNameLength(list);
        checkIsCarNameDuplicate(list);
    }

    private void checkIsCarNameListEmpty(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException(CarNameInputErrorMessages.LIST_EMPTY_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkCarNameLength(List<String> list) {
        for (String component : list) {
            if (component.length() > 5) {
                throw new IllegalArgumentException(CarNameInputErrorMessages.NAME_LENGTH_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void checkIsCarNameDuplicate(List<String> list) {
        HashSet<String> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            throw new IllegalArgumentException(CarNameInputErrorMessages.NAME_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }
}
