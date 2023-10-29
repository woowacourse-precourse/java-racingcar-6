package racingcar.global;

public enum GameIntConstant {
    CAR_NAME_LIMIT(5);
    private final Integer value;

    GameIntConstant(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
