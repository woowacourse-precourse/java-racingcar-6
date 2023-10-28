package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameManager {
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int BOUNDARY_MOVE_NUMBER = 4;

    public void moveCar(Car car) {
        if(isMove()){
            car.move();
        }
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private boolean isMove() {
        if (makeRandomNumber() < BOUNDARY_MOVE_NUMBER) {
            return false;
        }

        return true;
    }
}
