package racingcar.domain.car;

public class Position {
    private static final int START_POSITION = 0;
    private static final String POSITION_SYMBOL = "-";

    private int position = START_POSITION;

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return POSITION_SYMBOL.repeat(position);
    }

    public void increase() {
        position++;
    }
}

