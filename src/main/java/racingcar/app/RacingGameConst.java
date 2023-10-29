package racingcar.app;

public class RacingGameConst {
    public static final int INITIAL_CAR_PROGRESS = 0;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static final int MINIMUM_PICKUP_NUMBER = 0;
    public static final int MAXIMUM_PICKUP_NUMBER = 9;
    public static final int STANDARD_NUMBER = 4;

    public static final int MINIMUM_TRIAL_COUNT = 1;

    public static final String NAMES_EMPTY_MESSAGE = "적어도 하나 이상의 이름을 입력해야합니다.";
    public static final String NAMES_INCLUDE_EMPTY_MESSAGE = "이름은 빈 문자열이 될 수 없습니다.";
    public static final String NAMES_DUPLICATE_MESSAGE = "중복된 이름은 입력할 수 없습니다.";
    public static final String NAMES_OVER_LENGTH_MESSAGE = "자동차의 이름은 " + MAXIMUM_CAR_NAME_LENGTH + "자 이하만 가능합니다.";
    public static final String TRIAL_NOT_NUMBER_MESSAGE = "횟수는 숫자만 입력될 수 있습니다.";
    public static final String TRIAL_SMALLER_THAN_MINIMUM = "횟수는 " + MINIMUM_TRIAL_COUNT + "이상이 입력되어야 합니다.";

}
