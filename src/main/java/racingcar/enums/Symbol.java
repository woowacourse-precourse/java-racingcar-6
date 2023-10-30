package racingcar.enums;

public enum Symbol {
    CAR_NAME_DELIMITER(",");

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
