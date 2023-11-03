package racingcar.model;

public class TryCount {

    private final int count;

    private TryCount(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    public static TryCount valueOf(final int count) {
        return new TryCount(count);
    }

    public int getValue() {
        return count;
    }
}
