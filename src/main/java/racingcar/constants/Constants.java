package racingcar.constants;

public enum Constants {
    STANDARD_NUMBER(4), MIN_NUMBER(0), MAX_NUMBER(9), MAX_LENGTH(5), SEPARATOR(",");

    private int intValue;
    private String stringValue;

    private Constants(int value) {
        this.intValue = value;
    }

    private Constants(String value) {
        this.stringValue = value;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
