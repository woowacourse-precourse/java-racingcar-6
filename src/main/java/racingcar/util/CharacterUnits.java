package racingcar.util;

public enum CharacterUnits {
    ENTER("\n"),
    COMMA(","),
    BAR("-"),
    SPACE(" "),
    BLANK("");

    private final String unit;

    CharacterUnits(final String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
