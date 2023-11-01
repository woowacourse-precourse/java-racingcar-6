package racingcar.domain;

import static racingcar.constant.ErrorMessage.NUMERIC_INPUT_ERROR;

public class Count {
    private int value;

    public Count(String countInput) {
        this.value = validateNumericInput(countInput);
    }

    private int validateNumericInput(String countInput) {
        try {
            return Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INPUT_ERROR.getMessage());
        }
    }


    public void decrease() {
        value--;
    }

    public boolean playable() {
        return value != 0;
    }
}
