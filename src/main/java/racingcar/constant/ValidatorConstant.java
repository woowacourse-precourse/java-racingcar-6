package racingcar.constant;

public enum ValidatorConstant {
    INVALID_TRY_NUM("0");
    private final String value;

    ValidatorConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
