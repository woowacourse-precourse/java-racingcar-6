package racingcar.validator;

import static racingcar.model.ConstantValue.MAX_LEN_OF_CAR_NAME;
import static racingcar.model.ConstantValue.MIN_NUM_OF_CAR;
import static racingcar.model.ConstantValue.MIN_NUM_OF_MATCHES;

public enum ErrorMessage {
    BLANK("Blank is not Name"),
    LESS_THAN_MIN_NUM_OF_CAR("Less than the minimum number of cars : " + MIN_NUM_OF_CAR.getValue()),
    EXCEED_MAX_LEN_OF_CAR_NAME("The car name exceeds" + MAX_LEN_OF_CAR_NAME.getValue() + "characters in length."),
    NOT_INTEGER("Not integer"),
    LESS_THAN_MIN_NUM_OF_MATCHES("Less than the minimum number of matches : " + MIN_NUM_OF_MATCHES.getValue());

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
