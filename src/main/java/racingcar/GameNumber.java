package racingcar;

public enum GameNumber {
    GO(4),
    NAME_LENGTH(5);

    private final int number;

    GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
