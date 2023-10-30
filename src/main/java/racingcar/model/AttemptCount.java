package racingcar.model;

public class AttemptCount {
    private final int totalAttemptCount;

    public AttemptCount(String totalAttemptCount) {
        validate(totalAttemptCount);
        this.totalAttemptCount = Integer.parseInt(totalAttemptCount);
    }

    private void validate(String totalAttemptCount) {
        validateInteger(totalAttemptCount);
        validatePositiveNumber(totalAttemptCount);
    }

    private void validateInteger(String totalAttemptCount) {
        try {
            Integer.parseInt(totalAttemptCount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositiveNumber(String totalAttemptCount) {
        if(Integer.parseInt(totalAttemptCount) < 1)
            throw new IllegalArgumentException("시도횟수가 양수가 아닙니다.");
    }


}
