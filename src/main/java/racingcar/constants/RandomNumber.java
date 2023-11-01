package racingcar.constants;

public enum RandomNumber {
    MIN(0),
    MAX(9);

    private final Integer value;

    RandomNumber(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name();
    }

    public Integer getValue() {
        return value;
    }
}
