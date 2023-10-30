package racingcar.model.move;

public class RandomMove implements Move {

    private static final int STANDARD_VALUE = 4;

    @Override
    public boolean isMove(int number) {
        return number >= STANDARD_VALUE;
    }
}
