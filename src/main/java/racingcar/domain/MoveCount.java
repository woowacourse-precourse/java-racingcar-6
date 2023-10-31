package racingcar.domain;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import racingcar.Utils.ErrorMessage;

public class MoveCount {
    private int value;

    public MoveCount(int value) {
        isValidMoveCount(value);
        this.value = value;
    }

    public void isValidMoveCount(int value){
        if(value < 1){
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_MIN_NUMBER_ONE.getMessage());
        }
    }
    public boolean isOn() {
        return value > 0;
    }

    public void next() {
        value--;
    }
}
