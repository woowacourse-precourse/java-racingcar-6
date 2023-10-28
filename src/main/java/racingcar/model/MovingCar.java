package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import static constant.MessgeList.MOVING_FORWARD;

public class MovingCar {
    public MovingCar() {
    }

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public boolean isCarMoveForward() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= MOVING_FORWARD) {
            return true;
        }
        return false;
    }
}
