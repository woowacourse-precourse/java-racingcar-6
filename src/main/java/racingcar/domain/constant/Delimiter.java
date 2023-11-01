package racingcar.domain.constant;

public enum Delimiter {

    INPUT_NAME_DELIMITER(",");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
