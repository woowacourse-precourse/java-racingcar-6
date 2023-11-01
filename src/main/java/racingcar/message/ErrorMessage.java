package racingcar.message;

public class ErrorMessage {
    private ErrorMessage() {
    } // 인스턴트화 방지

    public static String INPUT_BLANK = "빈 값을 입력하였습니다.";
    public static String INPUT_NOT_INTEGER = "숫자를 입력해야합니다.";
    public static String INVALID_CAR_NAME = "자동차 이름은 5자 이하 이여야합니다.";
    public static String INVALID_NEGATIVE = "0 보다 작은 값을 입력할 수 없습니다.";
}
