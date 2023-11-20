package racingcar.message;

public enum OutputFormat {
    RACING_NOW_FORMAT("%s : %s%n"),
    RACING_WINNER_FORMAT("최종 우승자 : %s%n"),
    CAR_NAME_STEP_FORMAT(", "),
    LOCATION_STEP_FORMAT("-");
    private final String format;

    OutputFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
