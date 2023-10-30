package racingcar.config;

public enum RacingGameConfig {
    RANDOM_MIN_VALUE(0),
    RANDOM_MAX_VALUE(9),
    MOVE_CONDITION(4);

    private int value;

    RacingGameConfig(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
