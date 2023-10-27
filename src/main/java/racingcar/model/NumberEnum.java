package racingcar.model;

public enum NumberEnum {
    MIN_SIZE(2),
    MAX_LENGTH(5);


    private int Number;
    NumberEnum(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }
}
