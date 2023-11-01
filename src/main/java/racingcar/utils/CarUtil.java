package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class CarUtil {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean judgeGo(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }

}
