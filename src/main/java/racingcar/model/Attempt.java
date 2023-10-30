package racingcar.model;

public class Attempt {
    private final int attemptNumber;

    public Attempt(String attemptNumber) {
        validate(attemptNumber);
        this.attemptNumber = Integer.parseInt(attemptNumber);
    }

    private void validate(String attemptNumber) {
        validateInteger(attemptNumber);
        validatePositiveNumber(attemptNumber);
    }

    private void validateInteger(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositiveNumber(String attemptNumber) {
        if(Integer.parseInt(attemptNumber) < 1)
            throw new IllegalArgumentException("시도횟수가 양수가 아닙니다.");
    }
}
