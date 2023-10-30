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
            throw new IllegalArgumentException("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
        }
    }
}
