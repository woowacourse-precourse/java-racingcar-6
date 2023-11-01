package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validator;

public class Car {

    public static final int INIT_MOVE = 0;
    private static final int START_OF_RANGE = 0;
    private static final int END_OF_RANGE = 9;
    private static final int ACCEPT_MOVE = 4;
    private String carName;
    private int move;

    public Car(String carName, int move) {
        this.carName = Validator.checkName(carName);
        this.move = move;
    }

    public void carMoveOrStay() {
        if (Randoms.pickNumberInRange(START_OF_RANGE, END_OF_RANGE) >= ACCEPT_MOVE) {
            move++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getMove() {
        return move;
    }

}
