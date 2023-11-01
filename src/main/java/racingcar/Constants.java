package racingcar;

import java.util.regex.Pattern;

public class Constants {
    public static final int NAME_SIZE = 5;
    public static final int MOVE_NUM = 4;


    public static final String HYPHEN = "-";
    public static final String COMMAS = ",";
    public static final String COMMAS_AND_SPACE = ", ";
    public static final String ROUND_RESULT = "\n실행 결과";
    public static final String ROUND_RESULT_DELIMITER = " : ";

    public static final Pattern nameStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + COMMAS + "]*[가-힣\\w]$");
    public static final Pattern roundNumberPattern = Pattern.compile("^[1-9][0-9]*$");

    public static final String INVALID_CAR_LIST = "자동차 목록은 쉼표로 구분된 빈 칸이 없는 문자여야 합니다.";
    public static final String INVALID_CAR_NAME_SIZE = "자동차 이름의 길이는 1자~5자입니다.";
    public static final String INVALID_CAR_NAME_DUPLICATE = "자동차 이름은 중복이 불가능합니다.";
    public static final String INVALID_ROUND_NUM = "시도 횟수는 1 이상의 숫자여야 합니다.";

    public static final String WINNER_RESULT = "최종 우승자 : ";
}
