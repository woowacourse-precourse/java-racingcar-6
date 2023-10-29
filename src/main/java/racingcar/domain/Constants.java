package racingcar.domain;

public enum Constants {
    MAX_CAR_LENGTH(5);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

