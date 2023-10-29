package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryNumber {

    private int tryNum;

    private static final Pattern NUMBER = Pattern.compile("[1-9]\\d*"); //cacheing to stop regenerating pattern instance

    public TryNumber(String input) {

        tryNum = validatePositive(input);
    }

    int validatePositive(String input) {
        Matcher matcher = NUMBER.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("시도 횟수는 양의정수만 입력하세요");
        }

        return Integer.parseInt(input);
    }

    public int getTryNum() {
        return tryNum;
    }
}
