package racingcar.constant;

public enum GameStringConstant {

    BLANK(" ");

    private final String value;

    GameStringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
