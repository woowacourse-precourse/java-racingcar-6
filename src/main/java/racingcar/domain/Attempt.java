package racingcar.domain;

public class Attempt {
    private final int attemptNumber;//총 경기 횟수
    private int attemptCount;//여지껏 했던 경기 횟수

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
