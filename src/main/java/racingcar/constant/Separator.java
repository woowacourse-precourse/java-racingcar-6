package racingcar.constant;

public enum Separator {
    INPUT_CAR_SEPARATOR(","),
    OUTPUT_CAR_SEPARATOR(", "),
    KEY_VALUE_SEPARATOR(" : ");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
