package racingcar.domain.move;

public enum Move {

    FORWARD(1),
    STAY(0);

    private final int moveAmount;

    Move(final int moveAmount) {
        this.moveAmount = moveAmount;
    }
}
