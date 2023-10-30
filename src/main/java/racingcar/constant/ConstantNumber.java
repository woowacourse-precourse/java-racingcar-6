package racingcar.constant;

public enum ConstantNumber {
    CAR_NAME_MAX_SIZE(5),
    RANDOM_NUMBER_MIN_SIZE(0),
    RANDOM_NUMBER_MAX_SIZE(9),
    CAR_IS_STOP(3);

    private final int value;

    ConstantNumber(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }
}
