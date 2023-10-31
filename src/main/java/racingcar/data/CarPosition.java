package racingcar.data;

public class CarPosition {
    private int pos;
    private static final String NEGATIVE_INTEGER = "CarPosition cannot be a negative integer.";

    public CarPosition(int pos) {
        this.pos = pos;
        validateCarPosition(pos);
    }

    public static void validateCarPosition(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER);
        }
    }
}
