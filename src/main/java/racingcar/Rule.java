package racingcar;

import java.util.regex.Pattern;

public class Rule {
    public static final int MIN_CARNAMESIZE = 1;
    public static final int MAX_CARNAMESIZE = 5;
    public static final int MIN_RANDOM_NUM=0;
    public static final int MAX_RANDOM_NUM=9;
    public static final int GO_NUM =4;

    public static final String DELIMETER = ",";
    public static final String WINNER_DELIMETER = ",";
    public static final String ROUND_RESULT = "\n 실행 결과";
    public static final String ROUND_RESULT_DELIMETER = " : ";

    public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMETER + "]*[가-힣\\w]$");
    public static final Pattern roundNumPattern = Pattern.compile("^[1-9][0-9]*$");

    public static final String ERROR = "[ERROR] ";
    public static final String CAR_NAME_WRONG_ERROR = ERROR + "자동차 목록은 쉼표로 구분된 공백이 아닌 문자여야 한다.";
    public static final String CAR_NAME_SIZE_ERROR = ERROR + "자동차 목록은 5자 이하의 문자로 구성되어야 한다.";
    public static final String CAR_NAME_DUPLICATE_ERROR = ERROR + "자동차 목록은 중복이 없어야 한다.";
    public static final String ROUND_NUM_WRONG_ERROR = ERROR + "시도 횟수는 1 이상의 숫자여야 한다.";
    public static final String DASH = "-";

    public static final String WINNER_RESULT = "최종 우승자 : ";
}
