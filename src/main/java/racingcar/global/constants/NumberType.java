package racingcar.global.constants;

public enum NumberType {
    MAX_LENGTH_OF_NUMBER(5);

    private final Integer value;

    NumberType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
