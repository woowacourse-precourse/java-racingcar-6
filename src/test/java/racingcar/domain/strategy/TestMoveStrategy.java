package racingcar.domain.strategy;

public class TestMoveStrategy implements MoveStrategy {
    private static final int MIN_MOVING_NUMBER = 4;
    private int pickedNumber;

    public TestMoveStrategy(int number) {
        pickedNumber = number;
    }

    public void setNumber(final int number) {
        this.pickedNumber = number;
    }

    @Override
    public boolean canMove() {
        return pickedNumber >= MIN_MOVING_NUMBER;
    }
}
