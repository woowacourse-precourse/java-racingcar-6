package racingcar.utils;

import racingcar.utils.constant.message.ErrorMessage;

import java.util.List;

import static racingcar.utils.constant.Number.MAX_NAME_LENGTH;

public class Validation {

    public void isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOTHING.getMessage());
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
    }

    public void checkNameListSize(List<String> nameList) {
        if (nameList == null || nameList.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.TOO_FEW_NAMES.getMessage());
        }
    }

    public void checkName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LONG.getMessage());
        }
    }
}

