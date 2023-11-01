package racingcar.domain;

public enum TryingCountCondition {

    MIN_COUNT(1),
    MAX_COUNT(10);

    private final int count;

    TryingCountCondition(final int count) {
        this.count = count;
    }

    public static boolean isNotInRange(final int inputCount) {
        return MIN_COUNT.count > inputCount || MAX_COUNT.count < inputCount;
    }
}
