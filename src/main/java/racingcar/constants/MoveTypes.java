package racingcar.constants;

public enum MoveTypes {
    MOVE("-"),
    STOP("");

    private final String value;

    MoveTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
