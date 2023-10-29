package racingcar.model.car;

public enum CarSplitConstants {
    COMMAS(","),
    SPLIT_LIMIT("-1");

    private final String constants;

    CarSplitConstants(final String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
