package racingcar.constant;

public final class ErrorMessage {
    private ErrorMessage() {
    }

    public static final String CAR_NAME_BLANK_ERR_MESSAGE = "자동차 이름을 입력해 주세요.";
    public static final String CAR_NAME_LENGTH_OVER_ERR_MESSAGE = "자동차 이름은 5자 이하로 입력해 주세요.";

    public static final String MOVE_CNT_BLANK_ERR_MESSAGE = "이동 횟수를 입력해 주세요.";
    public static final String MOVE_CNT_NEGATIVE_ERR_MESSAGE = "이동 횟수는 0 이상으로 입력해 주세요.";
    public static final String MOVE_CNT_NOT_NUMBER_ERR_MESSAGE = "이동 횟수는 숫자로 입력해 주세요.";
}