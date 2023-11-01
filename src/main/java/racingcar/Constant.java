package racingcar;

/**
 * 상수 관리
 */
public class Constant {
    // 게임 진행 메시지
    public static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    // 전진 조건
    public static final int GENERATE_MIN_VALUE = 0;
    public static final int GENERATE_MAX_VALUE = 9;
    public static final int ENABLE_MOVE_VALUE = 4;

    // 이름 길이 제한
    public static final int LIMIT_NAME_LENGTH = 5;

    // 결과 출력 메시지
    public static final String RESULT_INFO_MESSAGE = "실행 결과";
    public static final String RESULT_CAR_MESSAGE = "%s : %s";
    public static final String RESULT_WINNER_MESSAGE = "최종 우승자 : %s";
    public static final String RESULT_MOVE_STR = "-";

    // 에러 메시지
    public static final String NOT_LENGTH_ERROR_MESSAGE = "5자 이하로 이름을 입력하세요";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "문자가 아닌 숫자를 입력하세요";
    public static final String NOT_VALID_NUMBER_ERROR_MESSAGE = "올바른 숫자를 입력하세요";
}
