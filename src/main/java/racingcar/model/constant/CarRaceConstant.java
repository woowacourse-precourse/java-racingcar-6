package racingcar.model.constant;

public enum CarRaceConstant {

    MIN_LENGTH(0),
    MAX_LENGTH(9),
    MOVE_MIN_VALUE(4),
    MAX_NAME_LENGTH(5);

    private final int constant;

    CarRaceConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}