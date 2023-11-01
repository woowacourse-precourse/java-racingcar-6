package racingcar.Message;

public class ExceptionMessage {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String FIVE_LENGTH_ERROR = ERROR_MESSAGE + "이름은 5자 이하만 가능합니다";
    public static final String NOTHING_ERROR = ERROR_MESSAGE + "이름을 비워둘 수 없습니다.";
    public static final String IS_SPACE_ERROR = ERROR_MESSAGE + "이름에 공백이 존재할 수 없습니다.";
    public static final String ONE_CAR_ERROR = ERROR_MESSAGE + "자동차 경주는 두 대 이상 가능합니다.";
    public static final String SAME_NAME_ERROR = ERROR_MESSAGE + "동일한 이름은 존재할 수 없습니다.";
    public static final String NULL_ERROR = ERROR_MESSAGE + "입력값이 null이 될 수 없습니다.";
    public static final String NUMBER_ERROR = ERROR_MESSAGE + "1 이상의 올바른 숫자 값을 입력해주세요.";
}
