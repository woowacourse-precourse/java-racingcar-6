package racingcar.constant;

public enum CarRaceConstant {
    MIN_LENGTH(0),
    MAX_LENGTH(9);

    private final int constant;

    CarRaceConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
