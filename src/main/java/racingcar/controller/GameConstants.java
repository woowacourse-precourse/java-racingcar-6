package racingcar.controller;

public enum GameConstants {

    MIN_NUMBER(0),
    MAX_NUMBER(9),
    MAX_LENGTH(5),
    MIN_NUMBER_TO_MOVE(4);

    private final int number;

    GameConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}