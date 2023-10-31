package util;

import java.util.regex.Pattern;

public class Constant {
    public static final int GO_NUMBER = 4;
    public static final int START_NUMBER = 0;
    public static final int END_NUMBER = 9;
    public static final int MAX_NAME_SIZE = 5;
    public static final Pattern timesPattern = Pattern.compile("^[1-9][0-9]*$");
    public static final Pattern spacePattern = Pattern.compile("^\\s*$");
    public static final Pattern commaPattern = Pattern.compile(".*,.*");
}
