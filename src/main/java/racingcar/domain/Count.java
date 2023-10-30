package racingcar.domain;

public class Count {
    private static final String LESS_THAN_ZERO_ERROR_MESSAGE = "경주 횟수가 0보다 작으면 안됩니다";
    private final int inputNumber;
    private int current = 0;

    public Count(int inputNumber) {
        validate(inputNumber);
        this.inputNumber = inputNumber;
    }

    private void validate (int inputNumber) {
        if (inputNumber < 0) {
            throw new IllegalArgumentException(LESS_THAN_ZERO_ERROR_MESSAGE);
        }
    }
}
