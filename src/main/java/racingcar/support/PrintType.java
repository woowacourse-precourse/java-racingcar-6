package racingcar.support;

public enum PrintType {
    DASH("-"),
    ;
    private final String type;

    PrintType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
