package constant;

public class ErrorMessage {
    private final static String ERROR_PREFIX = "[ERROR]";
    public final static String NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE = ERROR_PREFIX + " 양의 정수가 아닌 것을 입력했습니다. 게임을 종료합니다.";
    public final static String EMPTY_NAME_CASE_MESSAGE = ERROR_PREFIX + " 공백이 포함되었습니다. 게임을 종료합니다.";
    public final static String EXCEED_NAME_CASE_MESSAGE = ERROR_PREFIX + " 입력 길이가 초과되었습니다. 게임을 종료합니다.";
    public final static String UNCOMPETITIVE_CASE_MESSAGE = ERROR_PREFIX + " 참여자가 한명으로 경쟁이 불가능합니다. 게임을 종료합니다.";
}