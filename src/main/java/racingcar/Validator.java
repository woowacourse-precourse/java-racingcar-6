package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isNotValidInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}
