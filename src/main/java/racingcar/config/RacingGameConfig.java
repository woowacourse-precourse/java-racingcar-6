package racingcar.config;

public enum RacingGameConfig {
    RANDOM_MIN_VALUE(0),
    RANDOM_MAX_VALUE(9),
    MOVE_CONDITION(4),
    NUMBER_OF_TRY_MIN_VALUE(1),
    CAR_NAME_MAX_LENGTH(5);

    private int value;

    RacingGameConfig(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
