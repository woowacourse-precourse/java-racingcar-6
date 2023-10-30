package racingcar.model;

public class AttemptCount {
    private final int totalAttemptCount;

    public AttemptCount(String totalAttemptCount) {
        validate(totalAttemptCount);
        this.totalAttemptCount = Integer.parseInt(totalAttemptCount);
    }

    private void validate(String totalAttemptCount) {
        validateInteger(totalAttemptCount);
    }

    private void validateInteger(String totalAttemptCount) {
        try{
            Integer.parseInt(totalAttemptCount);
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException();
        }
    }

}
