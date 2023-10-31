package racingcar.model;

public class MoveCount {
    private int count = 0;

    public MoveCount() {
    }

    public int increaseMoveCount() {
        return ++count;
    }

    public int getCount() {
        return count;
    }
}
