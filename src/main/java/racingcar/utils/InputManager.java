package racingcar.utils;
import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int inputNumber(String numString){
        Integer number;
        try {
             number = Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 수 입력");
        }
        return number;
    }

}
