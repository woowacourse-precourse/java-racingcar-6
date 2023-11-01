package racingcar.utils;

import java.util.regex.Pattern;

public class RuleConstant {
    public static final int MAX_NAME_SIZE = 5;
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static final int CAN_DRIVE_CRITERIA = 4;
    public static final String DELIMITER = ",";
    public static final String DELIMITER_WINNER = ", ";
    public static final String ROUND_RESULT = "\n실행 결과";
    public static final String ROUND_RESULT_DELIMITER = " : ";
    public static final String WINNER_RESULT = "최종 우승자 : ";
    public static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z0-9가-힣]+(" + DELIMITER + "[A-Za-z0-9가-힣]+)*$");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    public static final String NOT_NUMBER = "입력값은 숫자여야 한다.";
    public static final String MUST_OVER_ZERO = "입력값은 0을 초과해야 한다.";
    public static final String INPUT_EMPTY = "입력값이 비면 안된다.";
    public static final String CAR_NAME_WRONG_ERROR =  "입력한 자동차들은 쉼표로 구분된 비어있지 않은 문자여야 한다.";
    public static final String CAR_NAME_SIZE_ERROR = "자동차 이름은 1~5자의 영어,한글,숫자 여야 한다.";
    public static final String CAR_NAME_DUPLICATE_ERROR = "자동차 목록은 중복이 없어야 한다.";
}
