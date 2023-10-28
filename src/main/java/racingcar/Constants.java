package racingcar;

import java.util.regex.Pattern;

public class Constants {
    public static final String DELIMITER = ",";
    public static final int valid_Length = 5;
    public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");
}
