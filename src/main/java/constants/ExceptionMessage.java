package constants;

public class ExceptionMessage {
    // 이름 목록 입력 예외 메세지
    public final static String EMPTY_INPUT = "입력된 값이 없습니다.";
    public final static String ENDS_WITH_COMMA = "마지막이 쉼표로 끝납니다.";
    public final static String CONTAINS_REPEATING_COMMAS = "쉼표 사이에 값이 없습니다.";
    public final static String EXCEEDED_NAME_LENGTH = "이름의 길이가 최대 길이를 넘습니다.";
    public final static String DUPLICATED_NAME = "중복되는 이름이 있습니다.";

    // 시도 횟수 입력 예외 메세지
    public final static String NOT_INTEGER = "정수가 아닌 값을 입력했습니다.";
    public final static String NOT_PLUS = "양수가 아닌 값을 입력했습니다.";
}
