package racingcar.domain;

public class Attempt {
    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 100;
    private int count;

    public Attempt(int count) {
        validateCountRange(count);
        this.count = count;
    }

    private void validateCountRange(int count) {
        if (!isInRange(count)) {
            throw new IllegalArgumentException("시도 회수는 1-100 사이로 입력해주세요");
        }
    }

    private boolean isInRange(int count) {
        return MIN_COUNT <= count && count <= MAX_COUNT;
    }

    public int count() {
        return count;
    }
}
