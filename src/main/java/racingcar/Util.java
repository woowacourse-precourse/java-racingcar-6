package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Util {
    static public boolean isNumeric (String stringToCheck){
        return (stringToCheck.matches("\\d+"));
    }

    static public String getUserInput() throws IllegalArgumentException {
        try {
            return (Console.readLine());
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException("Error : 입력값이 제대로 들어오지 않았습니다");
        }
    }
}
