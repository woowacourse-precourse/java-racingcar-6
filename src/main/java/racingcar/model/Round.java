package racingcar.model;

public class Round {

    private Count count;

    public Round(Count count) {
        this.count = count;
    }

    public void finishCurrentRound() {
        try {
            count = count.down();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[Error] 남은 라운드 횟수가 없습니다.", e);
        }
    }

    public boolean hasNotRemainingRound() {
        return count.isCountZero();
    }

    public boolean hasRemainingRound() {
        return !count.isCountZero();
    }
}
