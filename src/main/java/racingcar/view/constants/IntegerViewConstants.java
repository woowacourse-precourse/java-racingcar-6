package racingcar.view.constants;

public enum IntegerViewConstants {
    STARTING_POINT(0);

    private final Integer value;

    IntegerViewConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
