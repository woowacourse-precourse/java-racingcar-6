package racingcar.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validateNames(String names){
        String regex = "([a-zA-Z0-9]{1,5})(,[a-zA-Z0-9]{1,5})*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(names);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 형식으로 입력했습니다.");
        }
    }
}
