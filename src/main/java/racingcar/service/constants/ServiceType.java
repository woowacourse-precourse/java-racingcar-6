package racingcar.service.constants;

public enum ServiceType {
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    ADVANCE_FOR_MIN_NUMBER(4);

    private final int number;

    ServiceType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
