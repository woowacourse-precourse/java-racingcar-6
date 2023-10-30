package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class TrafficController {
    private int randomNumber;

    public TrafficController() {
        randomNumber = generateRandomNumber();
    }

    //0~9사이 랜덤 값 리턴
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    //랜덤 값이 4이상이면 전진(true), 아니면 후진(false)
    public boolean isMoveForward() {
        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
