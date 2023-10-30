package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    public int isMovable() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) {
            return randomNumber;
        }
        return 0;
    }
}
