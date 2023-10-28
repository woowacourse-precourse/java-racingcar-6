package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import static constant.MessgeList.MOVING_FORWARD;

public class MovingCar {
    private int count;
    public MovingCar() {
    }

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public void  moveCarForward() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= MOVING_FORWARD) {
            count++;
            return count;
        }
        return false;
    }
}
