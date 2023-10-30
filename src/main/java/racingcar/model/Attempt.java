package racingcar.model;

public class Attempt {
    private final int attemptNumber;

    private int attemptCount;

    public Attempt(String attemptNumber) {
        validate(attemptNumber);
        this.attemptNumber = Integer.parseInt(attemptNumber);
        attemptCount = 0;
    }

    public void increaseAttemptCount(){
        attemptCount++;
    }

    public boolean isContinue(){
        return attemptCount < attemptNumber;
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
