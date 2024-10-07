package racingcar.message;

public class ErrorMessage {
    private ErrorMessage() {} // 인스턴트화 방지
    public  static String INPUT_BLANK = "빈 값을 입력하셨습니다. 횟수를 입력해주세요";
    public static String INPUT_NOT_INTEGER = "숫자만 입력 할 수 있습니다.";
    public static String INPUT_ZERO = " 횟수는 1번이상 입력가능합니다. ";
    public static String EXCESS_NAME_LENGTH_LIMIT = "자동차 이름은 5자 이하여야 합니다.";
    public static String INVALID_TRIAL_COUNT = "시도횟수는 음수일 수 없습니다.";
    public static String INVALID_CAR_NAME = "자동차 이름이 없습니다. 이름을 입력해주세요";


}
