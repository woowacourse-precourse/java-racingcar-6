package racingcar.constant;

public enum GameConfig {
    ZERO(0),
    MIN_RANDOM_NUM(0),
    MAX_RANDOM_NUM(9),
    MAX_CAR_NAME_LENGTH(5),
    MIN_DISTANCE(4);
    private final int value;
    GameConfig(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
