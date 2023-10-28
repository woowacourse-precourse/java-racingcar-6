package racingcar.validation;

public class ExecutionNumber {
    static final String NOT_A_NUMBER_EXCEPTION = "숫자가 아닙니다.";

    public void validateExcutionNumber(String in) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_EXCEPTION);
        }
    }
}
