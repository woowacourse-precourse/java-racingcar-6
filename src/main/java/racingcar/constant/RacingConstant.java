package racingcar.constant;

public enum RacingConstant {

    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    PROCEED_THRESHOLD(4);

    private final int constant;

    RacingConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
