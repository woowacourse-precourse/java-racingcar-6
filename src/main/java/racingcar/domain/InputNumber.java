package racingcar.domain;


import racingcar.message.Messages;

public class InputNumber {
    private final int inputCount;
    public InputNumber(String number) {
        this.inputCount = stringToInt(number);
        validateRange(inputCount);
    }

    public boolean isEquals(int count) {
        return count == this.inputCount;
     }

    private int stringToInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.NOT_NUMBER_MESSAGE);
        }
    }

    private void validateRange(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(Messages.NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
