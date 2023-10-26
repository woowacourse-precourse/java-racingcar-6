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

    public static void validateOverOneNumber(String str){
        if(!str.matches("^[1-9][0-9]*$")){
            throw new IllegalArgumentException("1이상의 숫자만 입력 해야합니다.");
        }
    }
}
