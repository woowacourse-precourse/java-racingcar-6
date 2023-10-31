package racingcar.validation;

public class ExecutionNumber {
    static final String NOT_A_NUMBER_EXCEPTION = "숫자가 아닙니다.";
    static final String NUMBER_RANGE_EXCEPTION = "숫자 범위가 올바르지 않습니다.";

    public int validateExcutionNumber(String in) {
        int number = getNumber(in);
        checkRange(number);
        return number;
    }

    private int getNumber(String in) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_EXCEPTION);
        }
        return number;
    }

    private void checkRange(int number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
        }
    }
}
