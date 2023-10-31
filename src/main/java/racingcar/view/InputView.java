package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String NUMBER_FORMAT_REGEX = "^[1-9][0-9]*$"; // 양수 정수

    public static String getNamesString() {
        String input = Console.readLine();
        return input;
    }

    public static int getTryNumber() {
        String input = Console.readLine();
        validateTryNumber(input);
        return Integer.parseInt(input);
    }

    public static boolean validateTryNumber(String input) {
        Pattern p = Pattern.compile(NUMBER_FORMAT_REGEX);
        Matcher m = p.matcher(input);
        if (!m.matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 시도 횟수를 입력해주세요.");
        }
        return true;
    }
}