package racingcar.constants;

public enum Range {
    MAX_VALUE(9),MIN_VALUE(0);

    private int value;

    Range(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
