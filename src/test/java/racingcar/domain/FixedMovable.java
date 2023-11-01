package racingcar.domain;

public class FixedMovable implements Movable {

    private final boolean isMovable;

    public FixedMovable(boolean isMovable) {
        this.isMovable = isMovable;
    }

    @Override
    public boolean canMove() {
        return isMovable;
    }
}
