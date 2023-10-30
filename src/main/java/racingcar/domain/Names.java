package racingcar.domain;

import static racingcar.message.ErrorMessage.CAR_NAME_LENGTH_EXCEPTION_MESSAGE;
import static racingcar.message.MessageConstants.FIVE;

public record Names(String value) {

    public Names {
        String name = nameTrim(value);
        validationNameLength(name);
    }

    private void validationNameLength(String name) {
        if (name.length() > FIVE || name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private String nameTrim(String value) {
        return value.trim();
    }

}
