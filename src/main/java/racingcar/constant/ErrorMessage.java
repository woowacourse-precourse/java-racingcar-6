package racingcar.constant;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String CAR_NAME_WRONG_ERROR = ERROR + "자동차 목록은 쉼표로 구분된 비어있지 않은 문자여야 한다.";
    public static final String CAR_NAME_SIZE_ERROR = ERROR + "자동차 목록은 1자~5자의 문자로 구성되어야 한다.";
    public static final String CAR_NAME_DUPLICATE_ERROR = ERROR + "자동차 목록은 중복이 없어야 한다.";
    public static final String ROUND_NUM_WRONG_ERROR = ERROR + "시도 횟수는 1 이상의 숫자여야 한다.";

}
