package racingcar.util.constant;

public class ExceptionConstant {

    // 자동차 이름 입력
    public static String EMPTY_NAME = "공란입니다. 이름을 입력해주세요.";
    public static String INPUT_VALID_NAME_LENGTH = "이름은 5자 이하로 입력해주세요.";
    public static String INPUT_NAME_NOT_STARTS_WITH_EMPTY = "자동차 이름은 공백으로 시작할 수 없습니다.";
    public static String INVALID_INPUT_NAME = "잘못된 형식의 입력입니다.";

    // 시도 횟수 입력
    public static String INPUT_VALID_NUMBER = "숫자를 입력해주세요.";
    public static String INPUT_VALID_NUMBER_RANGE = "1 이상의 10억 이하의 숫자를 입력해주세요.";

    // 우승자 출력
    public static String MORE_THAN_TWO_WINNERS = "우승자가 2명 이상일 경우 출력은 ', '로 구분해야합니다.";

    public static int MINIMUM_NUMBER_VALUE = 1;
    public static int MAXIMUM_NUMBER_VALUE = (int)1e9;
    public static int MINIMUM_NAME_LENGTH = 5;
}
