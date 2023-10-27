package racingcar.enums;

public enum Constant {

    MAX_NAME_LENGTH(5);

    private final int constant;

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
