package racingcar.domain;

public class Round {
    private final int round;

    public Round(int round) {
        this.round = round;
    }

    public RoundDto toRoundDto() {
        return new RoundDto(round);
    }
}
