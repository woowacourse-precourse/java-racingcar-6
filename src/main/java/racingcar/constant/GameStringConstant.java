package racingcar.constant;

public enum GameStringConstant {

    BLANK(" "),
    SCORE_DIVDER(":"),
    SCORE_BAR("-");

    private final String value;

    GameStringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
