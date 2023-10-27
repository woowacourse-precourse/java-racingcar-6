package racingcar;

public class FixedCarEngine implements CarEngine {
    private final boolean canMove;

    public FixedCarEngine(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isStart() {
        return canMove;
    }
}
