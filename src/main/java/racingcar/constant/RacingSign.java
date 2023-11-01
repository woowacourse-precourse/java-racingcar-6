package racingcar.constant;

public enum RacingSign {
    RACING_PROGRESS_BAR("-"),
    NEW_LINE("\n"),
    WINNER_NAME_SEPARATOR(", "),
    CAR_NAME_SEPARATOR(","),
    CAR_NAME_SEPARATOR_TEXT("쉼표");

    private final String sign;

    RacingSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
