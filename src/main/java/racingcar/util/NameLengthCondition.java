package racingcar.util;

public enum NameLengthCondition {
    MIN_LENGTH(1),
    MAX_LENGTH(5);

    private final int length;

    NameLengthCondition(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
