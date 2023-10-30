package racingcar;

public enum CarConstants {
    START_RANDOM(0),
    END_RANDOM(9),
    INCREASE_NUM_FORWARD(1),
    TRIGGER_MINIMUM_FORWARD(4),
    LENGTH_CAR_NAME(5);

    private int intConst;

    CarConstants(int typeConst) {
        this.intConst = typeConst;
    }

    public int getConst() {
        return intConst;
    }

};
