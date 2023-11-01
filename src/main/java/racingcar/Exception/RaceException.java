package racingcar.Exception;

import static racingcar.Message.ExceptionMessage.NULL_ERROR;

import java.util.regex.Pattern;
import racingcar.Message.ExceptionMessage;

public class RaceException {
    final String checkPattern = "^[1-9]\\d*$";

    public int checkExceptionRace(String time) {
        if (time == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
        patternCheck(time);
        return Integer.parseInt(time);
    }

    public void patternCheck(String time) {
        if (!Pattern.matches(checkPattern, time)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_ERROR);
        }
    }

}
