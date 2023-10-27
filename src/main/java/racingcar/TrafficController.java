package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class TrafficController {
    private int randomNumber;

    public TrafficController() {
        generateRandomNumber();
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
    public int getRandomNumber() {
        return randomNumber;
    }

    public boolean isMoveForward() {
        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
