package racingcar.constant;

public enum NumberConstant {

    MIN_NUMBER_RANGE(0),
    MAX_NUMBER_RANGE(9),
    MIN_RESTRICT_NUMBER(4),
    CAR_NAME_LENGTH(5);


    private int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


}
