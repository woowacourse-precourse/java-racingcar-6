package racingcar.domain;

public class Rounds {
    private int rounds;

    public Rounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isNotOver(int rounds) {
        return this.rounds != rounds;
    }
}
