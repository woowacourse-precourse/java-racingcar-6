package racingcar.constants;

import java.util.regex.Pattern;

public class Constants {

    public static final String DASH_POSITION = "-";
    public static final Pattern gameCountPattern = Pattern.compile("^[0-9]*$");
    public static final Pattern nameStringPattern = Pattern.compile("^[a-zA-Z]\\S$");

}
