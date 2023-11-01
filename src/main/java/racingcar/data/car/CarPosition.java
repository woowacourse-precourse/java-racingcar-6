package racingcar.data.car;

public class CarPosition {
    private int pos;
    private static final String MARKER = "-";
    private static final String NEGATIVE_INTEGER_EXCEPTION = "CarPosition cannot be a negative integer.";

    public CarPosition(int pos) {
        validateCarPosition(pos);
        this.pos = pos;
    }

    public void move(int num) {
        pos += num;
    }

    public static void validateCarPosition(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_EXCEPTION);
        }
    }

    public int toInt() {
        return pos;
    }

    @Override
    public String toString() {
        return MARKER.repeat(pos);
    }
}
