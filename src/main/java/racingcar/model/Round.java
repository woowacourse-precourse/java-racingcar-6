package racingcar.model;

public class Round {
    private int round;

    public void setRound(String inputRound) {
        round = Integer.parseInt(inputRound);
    }

    public boolean isRemaining() {
        return round > 0;
    }

    public void subtractOne() {
        round -= 1;
    }
}
