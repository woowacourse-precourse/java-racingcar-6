package racingcar.Model;

import static racingcar.Constants.ErrorMessage.NUM_POSITIVE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryNumber {

    private int tryNum;

    private static final Pattern NUMBER_POSITIVE = Pattern.compile(
            "[1-9]\\d*"); //cacheing to stop regenerating pattern instance

    public TryNumber(String input) {

        tryNum = validatePositive(input);
    }

    int validatePositive(String input) {
        Matcher matcher = NUMBER_POSITIVE.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(NUM_POSITIVE.getMessage());
        }

        return Integer.parseInt(input);
    }

    public int getTryNum() {
        return tryNum;
    }
}
