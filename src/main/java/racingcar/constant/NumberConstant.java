package racingcar.constant;

public enum NumberConstant {

    CAR_NAME_MIN_SIZE(1)
    ,CAR_NAME_MAX_SIZE(5)
    ,RANDOM_MIN_NUMBER(0)
    ,RANDOM_MAX_NUMBER(9)
    ,GAME_PROCEED_STANDARD(4);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getMessage() {
        return this.number;
    }
}
