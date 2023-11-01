package racingcar.model;

public enum SystemValueConstants {

    LOOP_MIN(0),
    LOOP_MAX(9),
    FORWARD_STANDARD(4),
    COUNT_MIN(1),
    NAME_LENGTH_MAX(5),
    DEFAULT_LOCATION(0);

    private final int value;

    SystemValueConstants(int value) {
        this.value = value;
    }

    public static int loopMin() {
        return LOOP_MIN.value;
    }

    public static int loopMax() {
        return LOOP_MAX.value;
    }

    public static int forwardStandard() {
        return FORWARD_STANDARD.value;
    }

    public static int countMin() {
        return COUNT_MIN.value;
    }

    public static int nameMax() {
        return NAME_LENGTH_MAX.value;
    }

    public static int defaultLocation() {
        return DEFAULT_LOCATION.value;
    }

}
