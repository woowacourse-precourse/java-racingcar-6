package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerName {

    public void validateLength(String rawName) {
        if (isLengthOverFive(rawName)) {
            throw new IllegalArgumentException();
        }
    }

    //@ 여기 네이밍 고민
    private boolean isLengthOverFive(String rawName) {
        return rawName.length() > 5;
    }

    public void validateForm(String rawName) {
        if (!isNamesForm(rawName)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isNamesForm(String rawNames) {
        String pattern = "^[^,]+(,[^,]+)+$";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(rawNames);
        return matcher.matches();
    }

    public List<String> convertNames(String rawNames) {
        return Arrays.asList(rawNames.split(","));
    }
}
