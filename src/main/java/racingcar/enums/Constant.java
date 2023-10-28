package racingcar.enums;

public enum Constant {

    MAX_NAME_LENGTH(5),
    BEGIN_NUMBER(0),
    END_NUMBER(9),
    FORWARD_THRESHOLD(4);

    private final int constant;

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
