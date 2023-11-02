package racingcar.vo;

public final class RoundCount {

    private final Integer round;

    public RoundCount(Integer round) {
        this.round = round;
    }

    public boolean isRoundFinishState(int round) {
        return this.round.equals(round);
    }
}
