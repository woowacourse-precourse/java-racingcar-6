package racingcar.domain.car;

public class Position {
    private static final int START_POSITION = 0;
    private int position = START_POSITION;

    public int getPosition() {
        return position;
    }

    public void increase() {
        position++;
    }
}

