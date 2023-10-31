package racingcar.domain;

public class NumberOfRound {
    private int currentRound = 0;
    private final int totalRounds;

    public NumberOfRound(int totalRounds) {
        validate(totalRounds);
        this.totalRounds = totalRounds;
    }

    public void nextRound() {
        if (isLastRound()) {
            throw new IllegalStateException("마지막 라운드입니다.");
        }
        currentRound++;
    }

    public boolean isLastRound() {
        return currentRound >= totalRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("0 초과의 숫자만 입력 가능합니다.");
        }
    }
}

