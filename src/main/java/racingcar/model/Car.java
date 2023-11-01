package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validator;

public class Car {

    public static final int INIT_MOVE = 0;
    private String carName;
    private int move;

    public Car(String carName, int move) {
        this.carName = Validator.checkName(carName);
        this.move = move;
    }

    public void carMoveOrStay() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
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
