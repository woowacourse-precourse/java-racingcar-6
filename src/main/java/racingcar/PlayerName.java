package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerName {

    public void validateLength(String rawName) {
        if (isLengthOverFive(rawName)) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하로 입력해야 합니다.");
        }
    }

    private boolean isLengthOverFive(String rawName) {
        return rawName.length() > 5;
    }

    public void validateFormat(String rawName) {
        if (!isNamesFormat(rawName)){
            throw new IllegalArgumentException("[ERROR] ,로 구분되게 입력되어야 합니다.");
        }
    }

    private boolean isNamesFormat(String rawNames) {
        String pattern = "^[^,]+(,[^,]+)+$";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(rawNames);
        return matcher.matches();
    }

    public List<String> convertNames(String rawNames) {
        return Arrays.asList(rawNames.split(","));
    }
}
