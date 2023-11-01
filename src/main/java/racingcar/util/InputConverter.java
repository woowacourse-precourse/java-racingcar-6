package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputConverter {
    private static int MINMUM = 0;
    private static final Pattern NUMBER = Pattern.compile(Constants.NUMBER_MATCH_REGEX);

    public static int covertTimes(String times) {
        if (!validateTimes(times)) throw new IllegalArgumentException(ExceptionMessages.NUMBER_FORMAT_EXCEPTION);
        return Integer.parseInt(times);
    }

    private static boolean validateTimes(String times) {
        return checkInteger(times)&&checkMin(times);
    }

    private static boolean checkMin(String times) {
        return Integer.parseInt(times)>MINMUM;
    }

    private static boolean checkInteger(String times) {
        Matcher matcher =  NUMBER.matcher(times);
        return matcher.matches();
    }
}
