package racingcar.domain;
import racingcar.Utils.ErrorMessage;

public class MoveCount {
    private int value;

    private static final int VALID_MOVE_COUNT_MIN_NUMBER = 1;


    public MoveCount(int value) {
        isValidMoveCount(value);
        this.value = value;
    }

    public void isValidMoveCount(int value){
        if(value < VALID_MOVE_COUNT_MIN_NUMBER){
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
