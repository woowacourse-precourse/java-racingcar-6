package racingcar.constant;

public enum Number {
    MIN(0),
    MAX(9),
    STANDARD(4);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
