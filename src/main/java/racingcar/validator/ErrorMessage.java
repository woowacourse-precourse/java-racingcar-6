package racingcar.validator;

import static racingcar.model.ControlValue.MAX_LEN_OF_CAR_NAME;
import static racingcar.model.ControlValue.MIN_NUM_OF_CAR;

public enum ErrorMessage {
    LESS_THAN_MIN_NUM_OF_CAR("Less than the minimum number of cars : " + MIN_NUM_OF_CAR.getValue()),
    EXCEED_MAX_LEN_OF_CAR_NAME("The car name exceeds" + MAX_LEN_OF_CAR_NAME.getValue() + "characters in length.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
