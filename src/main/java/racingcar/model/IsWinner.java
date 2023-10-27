package racingcar.model;

public class IsWinner {

    private final boolean isWinner;

    public IsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public static IsWinner init() {
        return new IsWinner(false);
    }
}
