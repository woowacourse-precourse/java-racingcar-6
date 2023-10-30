package racingcar.domain.round;

public class Round {

    private int round;

    public Round(int round) {
        this.round = round;
    }

    public boolean isLeft() {
        round--;
        return round >= 0;
    }
}
