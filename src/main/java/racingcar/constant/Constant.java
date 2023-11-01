package racingcar.constant;

import java.util.regex.Pattern;

public class Constant {
    public static final int NAME_SIZE = 5;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int GO_NUM = 4;

    public static final String DELIMITER = ",";
    public static final String ROUND_RESULT = "\n실행 결과";
    public static final String ROUND_RESULT_DELIMITER = " : ";
    public static final String DASH = "-";
    public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");
    public static final Pattern roundNumPattern = Pattern.compile("^[1-9][0-9]*$");
}
