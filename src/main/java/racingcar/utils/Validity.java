package racingcar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.utils.Constants.*;

public class Validity {
    public static boolean isLessThanFiveCharacters(String str) {
        return str.length() <= MAX_CAR_NAME_LENGTH;
    }

    public static boolean isPlusIntNumber(String n) {
        Pattern pattern = Pattern.compile(REGEX_ONLY_NUMBER);
        Matcher matcher = pattern.matcher(n);
        boolean matches = matcher.matches();

        if(!matches) return false;

        return Long.parseLong(n) <= INT_MAX;
    }
}
