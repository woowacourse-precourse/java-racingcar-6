package racingcar.dto;

public class RaceResponse {
    private int attemptNumber;

    public RaceResponse(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }
}
