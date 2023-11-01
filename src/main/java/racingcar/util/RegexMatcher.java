package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {

    public static boolean match(String regex, String unvalid) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(unvalid);
        return matcher.matches();
    }
}
