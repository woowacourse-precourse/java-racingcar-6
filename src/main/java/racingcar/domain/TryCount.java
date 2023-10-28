package racingcar.domain;

public class TryCount {

    private final int count;

    private TryCount(int count) {
        this.count = count;
    }

    public static TryCount of(int count) {
        checkPositive(count);
        return new TryCount(count);
    }

    private static void checkPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return count;
    }
}
