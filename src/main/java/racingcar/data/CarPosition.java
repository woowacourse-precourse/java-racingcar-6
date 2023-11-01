package racingcar.data;

public class CarPosition {
    private int pos;
    private static final String MARKER = "-";
    private static final String NEGATIVE_INTEGER = "CarPosition cannot be a negative integer.";

    public CarPosition(int pos) {
        validateCarPosition(pos);
        this.pos = pos;
    }

    public void move(int num) {
        pos += num;
    }

    public static void validateCarPosition(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER);
        }
    }

    public int toInt() {
        return pos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            stringBuilder.append(MARKER);
        }
        return stringBuilder.toString();
    }
}
