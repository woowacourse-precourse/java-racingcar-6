package racingcar.constants;

public class DomainConstant {
    public static final int INITIAL_POSITION = 0;
    public static int SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE = 4;
    public static int WHEN_SUCCESS_MOVE_DISTANCE = 1;
    public static int WHEN_FAIL_MOVE_DISTANCE = 0;
    public static final String CAR_NAME_SEPARATOR = ",";
    public static final int RANDOM_NUMBER_MIN_VALUE = 0;
    public static final int RANDOM_NUMBER_MAX_VALUE = 9;

    private DomainConstant() {
        throw new AssertionError();
    }
}
