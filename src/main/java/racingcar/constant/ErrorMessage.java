package racingcar.constant;

public final class ErrorMessage {
    private ErrorMessage() {
    }

    public static final String CAR_NAME_BLANK = "자동차 이름을 입력해 주세요.";
    public static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 5자 이하로 입력해 주세요.";
    public static final String CAR_NAME_DUPLICATE = "중복된 자동차 이름입니다.";

    public static final String MOVE_CNT_BLANK = "이동 횟수를 입력해 주세요.";
    public static final String MOVE_CNT_NOT_POSITIVE_NUM = "이동 횟수는 1 이상으로 입력해 주세요.";
    public static final String MOVE_CNT_NOT_NUMBER = "이동 횟수는 숫자로 입력해 주세요.";
}