package racingcar.enums;

public enum ConverterConstant {
    DELIMITER(",");

    private final String value;

    ConverterConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
