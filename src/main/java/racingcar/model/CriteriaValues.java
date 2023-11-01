package racingcar.model;

public enum CriteriaValues {
    LOWER_BOUND(0),
    UPPER_BOUND(9),
    MOVE_CRITERIA(4);

    public final int value;

    CriteriaValues(int value) {
        this.value = value;
    }
}
