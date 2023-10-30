package racingcar.enums;

public enum Symbol {
    CAR_NAME_DELIMITER(","),
    KEY_VALUE_SEPARATOR(" : "),
    WINNER_DELIMITER(", "),
    POSITION_MARKER("-");

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
