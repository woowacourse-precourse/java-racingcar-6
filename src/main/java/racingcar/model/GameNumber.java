package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GameNumber {
    private int randomNumber;

    public int generateRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
