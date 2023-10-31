package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String input = "조나단,김치,라면";
        boolean isValidInput = isValidInputString(input);

        if (isValidInput) {
            System.out.println("입력이 유효합니다.");
        } else {
            System.out.println("입력이 유효하지 않습니다.");
        }
    }

    public static boolean isValidInputString(String input) {
        String regex = "^[\\w]+[\\w,]*[\\w]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
