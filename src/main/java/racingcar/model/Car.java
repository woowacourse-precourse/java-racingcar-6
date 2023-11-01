package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int move;

    public Car(String carName, int move) {
        this.carName = carName;
        this.move = move;
    }

    public void carMoveOrStay() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            move ++;
        }
    }

    public String getCarName() {
        return carName;
    }
    public int getMove() {
        return move;
    }

}
