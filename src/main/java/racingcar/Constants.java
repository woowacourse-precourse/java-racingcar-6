package racingcar;

import java.util.regex.Pattern;

public final class Constants {
    public static final String DELIMITER = ",";
    public static final int VALID_LENGTH  = 5;
    public static final int MINIMUM_LENGTH  = 4;
    public static final Pattern NAMES_STRING_PATTERN  = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");

    private Constants() {}
}
