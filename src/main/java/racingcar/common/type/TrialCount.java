package racingcar.common.type;

public final class TrialCount {
    private final int count;

    private TrialCount(int count) {
        validate(count);
        this.count = count;
    }

    public static TrialCount of(int count) {
        return new TrialCount(count);
    }

    private void validate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
