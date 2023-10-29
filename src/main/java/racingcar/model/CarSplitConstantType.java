package racingcar.model;

public enum CarSplitConstantType {
    COMMAS(","),
    SPLIT_LIMIT("-1");

    private final String constants;

    CarSplitConstantType(final String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
