package racingcar.constant;

public enum NumberConstant {
    MIN_NUMBER(0), MAX_NUMBER(9), MOVE_FORWARD_VALUE(4), MAX_LENGTH(5), MIN_LENGTH(0);
    final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
