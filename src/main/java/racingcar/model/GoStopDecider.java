package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Random;

public class GoStopDecider {
    private int movingCount;
    private boolean isGoForward;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean checkGoStop(int randomNumber) {
        return randomNumber >= 4;
    }

    private void decideGoStop(int randomNumber) {
        isGoForward = checkGoStop(randomNumber);
    }

    public void moveCarOnRandomValue(Car car) {
        decideGoStop(getRandomNumber());
        if(isGoForward) car.upDistance();
    }
}
