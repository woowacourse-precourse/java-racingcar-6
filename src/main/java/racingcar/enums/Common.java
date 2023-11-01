package racingcar.enums;

public enum Common {
    STANDARD_NUMBER(4),
    CAR_NAME_MAX_LENGTH(5),
    SEPARATOR(",");

    private int intValue;
    private String stringValue;

    private Common(int value) {
        this.intValue = value;
    }

    private Common(String value) {
        this.stringValue = value;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
