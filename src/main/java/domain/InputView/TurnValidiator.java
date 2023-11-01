package domain.InputView;

import java.util.regex.Pattern;

import static message.ErrorMessages.NEGATIVE_INPUT_ERROR;
import static message.ErrorMessages.WRONG_INPUT_ERROR;

public class TurnValidiator {
    public static final Pattern turnNumPattern = Pattern.compile("^[1-9][0-9]*$");

    public TurnValidiator(String num) {
        int newnum = checkNumber(num);
        if (newnum < 0) {
            throw new IllegalArgumentException(NEGATIVE_INPUT_ERROR);
        }

    }

    private int checkNumber(String turnNum) {
        matches(turnNum);
        return Integer.parseInt(turnNum);

    }

    private void matches(String turnNum) {
        if (!turnNumPattern.matcher(turnNum).matches()) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR);
        }

    }


}
