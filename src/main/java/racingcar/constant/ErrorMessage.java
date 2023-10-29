package racingcar.constant;

public class ErrorMessage {
    public static final String EMPTY_ERROR_MESSAGE = "빈 문자열은 입력될 수 없습니다.";
    public static final String MAX_LENGTH_ERROR_MESSAGE = "자동차 이름의 최대 길이는 5입니다.";
    public static final String DUPLICATION_ERROR_MESSAGE = "중복된 자동차 이름은 입력될 수 없습니다.";
    public static final String RACING_CAR_COUNT_ERROR_MESSAGE = "최소 %d대 이상의 자동차를 입력해주세요.";

    private ErrorMessage() {
    }
}
