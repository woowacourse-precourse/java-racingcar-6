package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;

import static constant.MessgeList.MOVING_FORWARD;

public class Car {
    private int[] distanceCount;

    public Car(List<String> carNameList) {
        distanceCount = new int[carNameList.size()];
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

    public void moveCarForwardOrStop(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            OutputView.printCarName(carNameList.get(i));
            if (isCarMoveForward()) {
                distanceCount[i]++;
                OutputView.printMovingForward();
            }
            OutputView.printMovingStop();
        }
    }
}
