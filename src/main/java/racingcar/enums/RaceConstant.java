package racingcar.enums;

public enum RaceConstant {
    MIN_ATTEMPT_NUMBER(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9);

    private final int number;

    RaceConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
