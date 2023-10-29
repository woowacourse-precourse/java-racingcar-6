package racingcar.constant;

public enum GameConfig {
    ZERO(0),
    MIN_RANDOM_NUM(1),
    MAX_RANDOM_NUM(9),
    MAX_CAR_NAME_LENGTH(5);
    private final int value;
    GameConfig(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
