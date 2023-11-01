package racingcar.domain.game;

public class ProgressCount {
    private final int maxProgressCount;
    private int currentProgressCount;

    public ProgressCount(int maxProgressCount, int currentProgressCount) {
        validateCount(maxProgressCount);
        this.maxProgressCount = maxProgressCount;
        this.currentProgressCount = currentProgressCount;
    }

    private void validateCount(int maxProgressCount) {
        if(maxProgressCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 0 이상이어야합니다.");
        }
    }

    public int getCurrentProgressCount() {
        return currentProgressCount;
    }

    public void increase() {
        currentProgressCount++;
    }

    public boolean isUnderLimit() {
        return currentProgressCount < maxProgressCount;
    }
}
