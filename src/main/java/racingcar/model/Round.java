package racingcar.model;

public class Round {

    private static final int NO_ROUND = 0;

    private int round;

    public Round(int round) {
        this.round = round;
    }

    public void finishCurrentRound() {
        this.round--;
    }

    public boolean hasNotRemainingRounds() {
        return this.round == NO_ROUND;
    }

    public boolean hasRemainingRounds() {
        return this.round != NO_ROUND;
    }
}
