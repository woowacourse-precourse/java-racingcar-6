package racingcar.view;

public enum NameConstraints {

    MAX_NAME_LENGTH(5);

    private final int value;

    NameConstraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
