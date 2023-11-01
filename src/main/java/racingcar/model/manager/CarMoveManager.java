package racingcar.model.manager;


import racingcar.util.RandomNumberValidator;

public class CarMoveManager {
    private static final int CHECK_NUMBER = 4;
    public boolean isMove(int number) {
        RandomNumberValidator.validate(number);
        return number >= CHECK_NUMBER;
    }
}
