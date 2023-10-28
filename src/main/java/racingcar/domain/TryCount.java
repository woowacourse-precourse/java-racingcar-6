package racingcar.domain;

public class TryCount {

    private final int tryCount;

    public TryCount(String tryCount) {
        validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateTryCount(String tryCount) {
        if (!Utils.isNaturalNumber(tryCount)) {
            throw new IllegalArgumentException("시도할 회수는 자연수만 가능합니다.");
        }
    }
}
