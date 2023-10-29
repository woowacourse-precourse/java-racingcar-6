package racingcar.domain.constants;

public enum number {
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MOVEMENT_POSSIBLE_NUMBER(4);


    private final int number;

    number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
