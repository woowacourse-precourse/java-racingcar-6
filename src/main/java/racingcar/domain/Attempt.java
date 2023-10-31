package racingcar.domain;

public class Attempt {
    private final int attemptNumber;
    private int attemptCount;

    public Attempt(String attemptNumber) {
        this.attemptNumber = Integer.parseInt(attemptNumber);
        attemptCount = 0;
    }

    public void increaseAttemptCount(){
        attemptCount++;
    }

    public boolean isContinue(){
        return attemptCount < attemptNumber;
    }


}
