package racingcar.model;

public class Round {

    private static final int NO_ROUND = 0;

    private int round;

    public Round(int round) {
        this.round = round;
    }

    public void finishCurrentRound() {
        if (hasNotRemainingRound()) {
            throw new IllegalArgumentException("[Error] 남은 라운드 횟수가 없습니다.");
        }
        this.round--;
    }

    public boolean hasNotRemainingRound() {
        return this.round == NO_ROUND;
    }

    public boolean hasRemainingRound() {
        return this.round != NO_ROUND;
    }
}
