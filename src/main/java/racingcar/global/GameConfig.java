package racingcar.global;

public enum GameConfig {
    CAR_NAME_LIMIT(5),
    MAGIC_NUMBER(4);
    private final Integer value;

    GameConfig(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
