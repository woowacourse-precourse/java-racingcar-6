package racingcar.constant;

public enum CarInformConstant {
    DASH_STRING("-");

    private final String value;

    CarInformConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
