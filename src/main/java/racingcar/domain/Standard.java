package racingcar.domain;

public enum Standard {
    Four(4),
    Five(5);
    private final int value;

    Standard(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
