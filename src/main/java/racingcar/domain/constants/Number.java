package racingcar.domain.constants;

public enum Number {
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MOVEMENT_POSSIBLE_NUMBER(4);


    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
