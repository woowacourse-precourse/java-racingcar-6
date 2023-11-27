package racingcar.view.output.constant;

public enum OutputFormatConstant {
    PRINT_CAR_NAME_AND_DISTANCE_FORMAT("%s : %s");

    private final String format;

    OutputFormatConstant(final String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}