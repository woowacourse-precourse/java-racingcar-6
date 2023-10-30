package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GoStopDecider {

    private static final int GO_STANDARD_NUMBER = 4;
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean checkGoStop(int randomNumber) {
        return randomNumber >= GO_STANDARD_NUMBER;
    }

    public void moveCarOnRandomValue(Car car) {
        if (checkGoStop(getRandomNumber())) {
            car.upDistance();
        }
    }
}
