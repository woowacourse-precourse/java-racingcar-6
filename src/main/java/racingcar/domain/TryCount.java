package racingcar.domain;

public class TryCount {

    private final int count;

    private TryCount(int count) {
        this.count = count;
    }

    public static TryCount of(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        return new TryCount(count);
    }

    public int getCount() {
        return count;
    }
}
