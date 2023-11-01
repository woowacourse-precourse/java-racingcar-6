package racingcar.validation;

import java.util.Collections;
import java.util.List;

public class NameValidator {

    public static final int MAX_LENGTH = 5;

    public void isDuplicatedName(List<String> nameList) {
        for (int i = 0; i < nameList.size(); i++) {
            int count = Collections.frequency(nameList, nameList.get(i));
            if (count > 1) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
            }
        }
    }

    public void isMaxLengthExceeded(String name) {
        if ((name.length() > MAX_LENGTH)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getMessage());
        }
    }

    public void isValidNames(String names) {
        if (names.startsWith(",") || names.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAMES.getMessage());
        }
    }
}
