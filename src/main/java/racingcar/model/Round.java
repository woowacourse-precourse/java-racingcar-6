package racingcar.model;

public class Round {
    private int round;

    public Round(String inputString) {
        round = Integer.parseInt(inputString);
    }

    public boolean isRemaining() {
        return round > 0;
    }

    public void subtractOne() {
        round -= 1;
    }
}
