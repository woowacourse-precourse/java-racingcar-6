package racingcar.model;

public enum NumberEnum {
    MAX_LENGTH(5);

    private int Number;
    NumberEnum(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }
}
