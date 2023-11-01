package racingcar.constant;

public enum DomainConstant {
    // Lap
    LAP_MIN_SIZE(0),
    LAP_INCREASE_COUNT(1),
    // ExtractTrack
    EXTRACT_TRACK_MIN_SIZE(0),
    EXTRACT_TRACK_DECREASE(1),
    //CarName
    CAR_NAME_SIZE(5);

    private final int value;

    DomainConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
