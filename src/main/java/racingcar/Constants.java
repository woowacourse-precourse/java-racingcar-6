package racingcar;

import java.util.regex.Pattern;

public class Constants {
	public static final String COMMA = ",";
	public static final int NAME_SIZE = 5;
	public static final int GO_NUM = 4;
	public static final String DASH = "-";
	public static final String COLON = " : ";
	public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + COMMA + "]*[가-힣\\w]$");
	public static final Pattern roundNumPattern = Pattern.compile("^[1-9][0-9]*$");
}
