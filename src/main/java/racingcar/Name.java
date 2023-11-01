package racingcar;

import racingcar.utils.ErrorMessage;

public class Name {
    private String value;

    Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
