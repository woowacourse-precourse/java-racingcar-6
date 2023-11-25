package racingcar.utils;

public enum StringConstants {
    CURRENT_POSITION("-"),
    ENGLISH_PATTERN("^[a-zA-Z]*$");

    private String value;

    StringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

