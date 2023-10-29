package racingcar.Exception;

import java.util.regex.Pattern;
import racingcar.Message.ExceptionMessage;
public class RaceException {
    final String checkPattern = "^[1-9]\\d*$";
    public boolean checkExceptionRace(String time){
        if (!Pattern.matches(checkPattern, time))
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_ERROR);
        else return true;
    }

}
