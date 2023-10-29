package util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNameRegexValidator {

    private static final Pattern CHARS_OR_COMMA_PATTERN = Pattern.compile("^[\\w,]+$");

    public static boolean isCharsOrComma(String value) {
        Matcher matcher = CHARS_OR_COMMA_PATTERN.matcher(value);
        return matcher.matches();
    }


}
