package racingcar.status;

public enum ProgressType {
    RESTART("1"),
    EXIT("2");

    private final String value;

    ProgressType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
